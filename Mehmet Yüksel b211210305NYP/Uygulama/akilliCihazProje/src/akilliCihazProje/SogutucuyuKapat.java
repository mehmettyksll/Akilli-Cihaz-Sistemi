package akilliCihazProje;

public class SogutucuyuKapat extends Islem 
{
	  public SogutucuyuKapat(IEkran ekran)
	  {
		  super(ekran);
	  }
	  
	  public void islemYap()
	  {
		  ekran.mesajGoruntule("So�utucu Kapat�ld�...");
	  }
}
