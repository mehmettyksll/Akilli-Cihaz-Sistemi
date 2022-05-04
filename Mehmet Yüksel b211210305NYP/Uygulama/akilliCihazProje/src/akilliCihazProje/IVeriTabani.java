package akilliCihazProje;

import java.sql.Connection;

public interface IVeriTabani
{
	public java.sql.Connection baglan();
	
	public void sorgula();
	
	public int kullaniciAdiDogrula(String kAdi,Connection connect);
	
	public int sifreDogrula(String sifre, Connection connect);
	
	public int yetkiDogrula(String kAdi, Connection connect);
	
	public void mesajGonder(int sicaklik, Connection connect);
	
	public void observerMesajGonderVt(Connection connect);
}
