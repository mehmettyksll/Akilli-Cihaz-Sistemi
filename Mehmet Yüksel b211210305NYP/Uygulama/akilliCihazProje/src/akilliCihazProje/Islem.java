package akilliCihazProje;

public abstract class Islem
{
	 protected final IEkran ekran;
	 
	 protected Islem(IEkran ekran)
	 {
		   this.ekran = ekran;
	 }
	 
     public abstract void islemYap();
}
