package akilliCihazProje;

public class MemberObserver extends Observer
{
	@Override
	public void Write() // Burada veritaban�na uyar� mesaj� yazd�r�l�yor ilgili member�n. �uan MemberObserver=> mehmetyksl i�in
	{
		IVeriTabani postgreSql=new PostgreSqlVeriTabani();
		
		java.sql.Connection connect=null;
		connect=postgreSql.baglan();
		
		postgreSql.observerMesajGonderVt(connect);

	}
}
