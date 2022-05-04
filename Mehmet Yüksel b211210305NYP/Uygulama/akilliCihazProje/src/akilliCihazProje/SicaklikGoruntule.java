package akilliCihazProje;

public class SicaklikGoruntule extends Islem 
{
	private SicaklikOlc sicaklikOlc; // Association baðýntýsý, bir nesne diðer bir nesneyi üye olarak içerisinde barýndýrmak zorunda. 
									 // Çünkü sýcaklýk deðerini ölçmeden görüntülememiz mümkün deðil.
	
	public SicaklikGoruntule(IEkran ekran)
	{
		super(ekran);
	}

	@Override
	public void islemYap() 
	{
		sicaklikOlc=new SicaklikOlc(ekran);
		int sicaklik=sicaklikOlc.SicaklikUret();
		System.out.println("Sýcaklýk: "+sicaklik);
		
	}
	
}
