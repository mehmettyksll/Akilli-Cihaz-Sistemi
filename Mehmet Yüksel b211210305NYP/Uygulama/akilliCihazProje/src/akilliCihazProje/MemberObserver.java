package akilliCihazProje;

public class MemberObserver extends Observer
{
	@Override
	public void Write() // Burada veritabanýna uyarý mesajý yazdýrýlýyor ilgili memberýn. Þuan MemberObserver=> mehmetyksl için
	{
		IVeriTabani postgreSql=new PostgreSqlVeriTabani();
		
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		postgreSql.observerMesajGonderVt(connect);

	}
}
