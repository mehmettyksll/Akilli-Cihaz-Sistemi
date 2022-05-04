 package akilliCihazProje;

public class AgArayuzu implements IAgArayuzu
{
	IEkran ekran=new Ekran();
	
	public void sicaklikGoruntule()
	{
		Islem sicaklikGoruntule=new SicaklikGoruntule(ekran);
		sicaklikGoruntule.islemYap();
	}
	
	public void sogutucuyuAc()
	{
		IEyleyiciModul eyleyiciModul=new EyleyiciModul();
		eyleyiciModul.sogutucuyuAc();
	}
	
	public void sogutucuyuKapat()
	{
		IEyleyiciModul eyleyiciModul=new EyleyiciModul();
		eyleyiciModul.sogutucuyuKapat();
	}
	
	public void cikis()
	{
		Islem cikis=new Cikis(ekran); 
		cikis.islemYap();
	}
	
}
