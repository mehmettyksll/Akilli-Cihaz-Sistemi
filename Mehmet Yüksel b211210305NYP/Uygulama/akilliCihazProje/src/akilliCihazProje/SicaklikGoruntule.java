package akilliCihazProje;

public class SicaklikGoruntule extends Islem 
{
	private SicaklikOlc sicaklikOlc; // Association ba��nt�s�, bir nesne di�er bir nesneyi �ye olarak i�erisinde bar�nd�rmak zorunda. 
									 // ��nk� s�cakl�k de�erini �l�meden g�r�nt�lememiz m�mk�n de�il.
	
	public SicaklikGoruntule(IEkran ekran)
	{
		super(ekran);
	}

	@Override
	public void islemYap() 
	{
		sicaklikOlc=new SicaklikOlc(ekran);
		int sicaklik=sicaklikOlc.SicaklikUret();
		System.out.println("S�cakl�k: "+sicaklik);
		
	}
	
}
