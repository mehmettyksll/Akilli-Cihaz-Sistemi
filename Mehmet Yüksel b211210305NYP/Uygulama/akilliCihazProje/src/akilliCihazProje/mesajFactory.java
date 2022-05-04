package akilliCihazProje;

public class mesajFactory
{
	// S�cakl�k �l��ld�kten sonra e�er 40 dereceyi ge�tiyse mehmetyksl kullan�c�s�na "Uyar�: S�cakl�k 40 dereceyi ge�ti." 
	//�eklinde mesaj g�nderiliyor."
	public void MesajGonder(int sicaklik)
	{
		IEkran ekran=new Ekran();
		IVeriTabani postgreSql=new PostgreSqlVeriTabani();
		
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		postgreSql.mesajGonder(sicaklik, connect);
	}
}
