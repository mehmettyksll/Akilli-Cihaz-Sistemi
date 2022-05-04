package akilliCihazProje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class PostgreSqlVeriTabani implements IVeriTabani
{
	IEkran ekran=new Ekran();
	
	@Override
	public Connection baglan() {
		
		// veri tabani islemleri
		java.sql.Connection connect=null;
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			connect= DriverManager.getConnection("jdbc:postgresql://localhost:5432/vt_AkilliCihaz", "postgres", "123456");
			if(connect!=null)
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýlý!");
			}
			else
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýsýz!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		return connect;	
		// ----- veri tabani islemleri bitti dogrulamaDegeri döndürüldü.
	}

	@Override
	public void sorgula() 
	{
	}
	
	public int kullaniciAdiDogrula(String kAdi, Connection connect)
	{
		int dogrulamaDegeri=0; // 0 ise dogrulanamadý, 1 ise dogrulandý
	
		try 
		{
			if(connect!=null)
			{	
				java.sql.Statement st=connect.createStatement();
				String query="select * from tbl_kullanicihesaplari where kullanici_adi='"+kAdi+"'";
				
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
				{
					ekran.mesajGoruntule("Kullanýcý Adý Doðrulama Baþarýlý...\n");
					dogrulamaDegeri=1;
				}
				else
				{
					ekran.mesajGoruntule("Kullanýcý Adý Doðrulama Baþarýsýz...\n");
					dogrulamaDegeri=0;
				}
			}
			else
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýsýz!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		// ----- veri tabani islemleri bitti dogrulamaDegeri döndürüldü.
		return dogrulamaDegeri;
	}

	@Override
	public int sifreDogrula(String sifre, Connection connect) 
	{
		int dogrulamaDegeri=0; // 0 ise dogrulanamadý, 1 ise dogrulandý
		
		try 
		{
			if(connect!=null)
			{
				java.sql.Statement st=connect.createStatement();
				String query="select * from tbl_kullanicihesaplari where sifre='"+sifre+"'";
				
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
				{
					ekran.mesajGoruntule("Þifre Doðrulama Baþarýlý...");
					dogrulamaDegeri=1;
				}
				else
				{
					ekran.mesajGoruntule("Þifre Doðrulama Baþarýsýz...");
					dogrulamaDegeri=0;
				}
				
			}
			else
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýsýz!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		// ----- veri tabani islemleri bitti dogrulamaDegeri döndürüldü.
		
		return dogrulamaDegeri;
	}

	@Override
	public int yetkiDogrula(String kAdi, Connection connect) 
	{
		int yetki=0;
		
		try 
		{
			if(connect!=null)
			{
				java.sql.Statement st=connect.createStatement();
				String query="select * from tbl_kullanicihesaplari where kullanici_adi='"+kAdi+"'";
				
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
				{
					yetki= rs.getInt("yetki");
				}
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		return yetki;
	}
	
	// FactoryMethod kullanýmý için oluþturuldu. Sýcaklýk 40 dereceyi geçer ise mehmetyksl'ye mesaj gönderiliyor.
	public void mesajGonder(int sicaklik, Connection connect)
	{
		try 
		{
			if(connect!=null)
			{	
				String mesaj="Uyarý: Sýcaklýk "+sicaklik+" derece!";
				java.sql.Statement st=connect.createStatement();	
				String query="insert into tbl_mesajlar(kullanici_id, mesaj) values('1','"+mesaj+"')"; // mehmetyksl kullanýcýsýnýn id'si 1
				st.executeUpdate(query);
			}
			else
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýsýz!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
	}
		
	// Observer Tasarým Deseninin uygulanmasý için sýcaklýk 0 ýn altýna düþtüðünde ilgili member'a mesaj yazdýrýlýyor. Tek kullanýcýya mesaj
	// göndertiyorum. => mehmetyksl kullanicisi
	public void observerMesajGonderVt(Connection connect)
	{
		try 
		{
			if(connect!=null)
			{	
				String mesaj="Uyarý: Sýcaklýk 0 derecenin altýna düþtü!";
				java.sql.Statement st=connect.createStatement();	
				String query="insert into tbl_mesajlar(kullanici_id, mesaj) values('1','"+mesaj+"')"; // mehmetyksl kullanýcýsýnýn id'si 1
				st.executeUpdate(query);
			}
			else
			{
				ekran.mesajGoruntule("Veri Tabanýna Baðlantý Baþarýsýz!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
	}

}
