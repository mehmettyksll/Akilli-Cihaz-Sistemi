package akilliCihazProje;
import java.util.Random;

public class SicaklikOlc extends Islem 
{
	
	public SicaklikOlc(IEkran ekran)
	{
		super(ekran);
	}
	
	
	public int SicaklikUret() 
	{
		Random rastgele = new Random();
		int sayi = rastgele.nextInt(55); // 0-55 aras� say� �retir. 
		int uretilen=sayi-10; // -10 ile +45 aras�nda s�cakl�k �retsin istedi�im i�in b�yle yapt�m.
		
		// -> FactoryMethod Tasar�m� i�in
		// S�cakl�k 40 derecenin �st�nde ise admine uyar� mesaj� g�nderiliyor. (admin=mehmetyksl)
		if(uretilen>=40)
		{
			var mesajFactory = new mesajFactory();
			mesajFactory.MesajGonder(uretilen);
		}
		
		
		// -> Observer Tasar�m� i�in
		// sicaklik 0 derecenin altinda ise haber ver. 
		if(uretilen<0)
		{
			SicaklikManager manager=new SicaklikManager();
			manager.AddMember(new MemberObserver());
			manager.Sicaklik();
		}
		
		return uretilen;
	}

	@Override
	public void islemYap() {
	}
}
