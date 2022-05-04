package akilliCihazProje;

public class EyleyiciModul implements IEyleyiciModul
{
	IEkran ekran=new Ekran();
	@Override
	public void sogutucuyuAc() 
	{
		Islem sogutucuyuAc=new SogutucuyuAc(ekran);   // buradan da eyleyici modulu act�rabilirz galiba. eyleyici mod�lde sogutucuyu acar.
		sogutucuyuAc.islemYap();
		
	}

	@Override
	public void sogutucuyuKapat()
	{
		Islem sogutucuyuKapat=new SogutucuyuKapat(ekran); 
		sogutucuyuKapat.islemYap();
		
	}

}
