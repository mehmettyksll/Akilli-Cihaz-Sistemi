package akilliCihazProje;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class AkilliCihazSistemi implements IAkilliCihazSistemi
{
	IEkran ekran=new Ekran();
	IVeriTabani postgreSql=new PostgreSqlVeriTabani();
	
	public int kullaniciAdiDogrula(String kAdi)
	{
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		int dogrulamaDegeri=0; // 0 ise dogrulanamadý, 1 ise dogrulandý
		dogrulamaDegeri=postgreSql.kullaniciAdiDogrula(kAdi,connect);

		return dogrulamaDegeri;
	}
	
	public int sifreDogrula(String sifre)
	{
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		int dogrulamaDegeri=0; // 0 ise dogrulanamadý, 1 ise dogrulandý
		dogrulamaDegeri=postgreSql.sifreDogrula(sifre, connect);
		
		return dogrulamaDegeri;
	}
	
}
