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
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�l�!");
			}
			else
			{
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�s�z!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		return connect;	
		// ----- veri tabani islemleri bitti dogrulamaDegeri d�nd�r�ld�.
	}

	@Override
	public void sorgula() 
	{
	}
	
	public int kullaniciAdiDogrula(String kAdi, Connection connect)
	{
		int dogrulamaDegeri=0; // 0 ise dogrulanamad�, 1 ise dogruland�
	
		try 
		{
			if(connect!=null)
			{	
				java.sql.Statement st=connect.createStatement();
				String query="select * from tbl_kullanicihesaplari where kullanici_adi='"+kAdi+"'";
				
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
				{
					ekran.mesajGoruntule("Kullan�c� Ad� Do�rulama Ba�ar�l�...\n");
					dogrulamaDegeri=1;
				}
				else
				{
					ekran.mesajGoruntule("Kullan�c� Ad� Do�rulama Ba�ar�s�z...\n");
					dogrulamaDegeri=0;
				}
			}
			else
			{
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�s�z!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		// ----- veri tabani islemleri bitti dogrulamaDegeri d�nd�r�ld�.
		return dogrulamaDegeri;
	}

	@Override
	public int sifreDogrula(String sifre, Connection connect) 
	{
		int dogrulamaDegeri=0; // 0 ise dogrulanamad�, 1 ise dogruland�
		
		try 
		{
			if(connect!=null)
			{
				java.sql.Statement st=connect.createStatement();
				String query="select * from tbl_kullanicihesaplari where sifre='"+sifre+"'";
				
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next())
				{
					ekran.mesajGoruntule("�ifre Do�rulama Ba�ar�l�...");
					dogrulamaDegeri=1;
				}
				else
				{
					ekran.mesajGoruntule("�ifre Do�rulama Ba�ar�s�z...");
					dogrulamaDegeri=0;
				}
				
			}
			else
			{
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�s�z!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
		
		// ----- veri tabani islemleri bitti dogrulamaDegeri d�nd�r�ld�.
		
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
	
	// FactoryMethod kullan�m� i�in olu�turuldu. S�cakl�k 40 dereceyi ge�er ise mehmetyksl'ye mesaj g�nderiliyor.
	public void mesajGonder(int sicaklik, Connection connect)
	{
		try 
		{
			if(connect!=null)
			{	
				String mesaj="Uyar�: S�cakl�k "+sicaklik+" derece!";
				java.sql.Statement st=connect.createStatement();	
				String query="insert into tbl_mesajlar(kullanici_id, mesaj) values('1','"+mesaj+"')"; // mehmetyksl kullan�c�s�n�n id'si 1
				st.executeUpdate(query);
			}
			else
			{
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�s�z!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
	}
		
	// Observer Tasar�m Deseninin uygulanmas� i�in s�cakl�k 0 �n alt�na d��t���nde ilgili member'a mesaj yazd�r�l�yor. Tek kullan�c�ya mesaj
	// g�ndertiyorum. => mehmetyksl kullanicisi
	public void observerMesajGonderVt(Connection connect)
	{
		try 
		{
			if(connect!=null)
			{	
				String mesaj="Uyar�: S�cakl�k 0 derecenin alt�na d��t�!";
				java.sql.Statement st=connect.createStatement();	
				String query="insert into tbl_mesajlar(kullanici_id, mesaj) values('1','"+mesaj+"')"; // mehmetyksl kullan�c�s�n�n id'si 1
				st.executeUpdate(query);
			}
			else
			{
				ekran.mesajGoruntule("Veri Taban�na Ba�lant� Ba�ar�s�z!");
			}
		}
		catch(Exception e)
		{
			ekran.mesajGoruntule("Hata: "+e);
		}
	}

}
