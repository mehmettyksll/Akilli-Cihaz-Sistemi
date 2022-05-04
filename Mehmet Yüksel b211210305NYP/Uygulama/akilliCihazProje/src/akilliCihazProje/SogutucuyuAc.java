package akilliCihazProje;

public class SogutucuyuAc extends Islem 
{
	  public SogutucuyuAc(IEkran ekran)
	  {
		  super(ekran);
	  }
	  
	  public void islemYap()
	  {
		  ekran.mesajGoruntule("Soðutucu Açýldý...");
	  }
}
