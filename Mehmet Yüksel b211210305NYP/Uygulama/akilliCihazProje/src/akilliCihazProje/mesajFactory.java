package akilliCihazProje;

public class mesajFactory
{
	// Sýcaklýk ölçüldükten sonra eðer 40 dereceyi geçtiyse mehmetyksl kullanýcýsýna "Uyarý: Sýcaklýk 40 dereceyi geçti." 
	//þeklinde mesaj gönderiliyor."
	public void MesajGonder(int sicaklik)
	{
		IEkran ekran=new Ekran();
		IVeriTabani postgreSql=new PostgreSqlVeriTabani();
		
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		postgreSql.mesajGonder(sicaklik, connect);
	}
}
