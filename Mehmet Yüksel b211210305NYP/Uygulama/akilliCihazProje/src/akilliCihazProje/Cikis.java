package akilliCihazProje;

public class Cikis extends Islem 
{
	  public Cikis(IEkran ekran)
	  {
		  super(ekran);
	  }
	  
	  public void islemYap()
	  {
		  ekran.mesajGoruntule("��k�� Yap�ld�...");
		  System.exit(1);
	  }
}