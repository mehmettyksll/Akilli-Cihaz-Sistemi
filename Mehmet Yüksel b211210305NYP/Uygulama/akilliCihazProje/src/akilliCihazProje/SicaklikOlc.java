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
		int sayi = rastgele.nextInt(55); // 0-55 arası sayı üretir. 
		int uretilen=sayi-10; // -10 ile +45 arasında sıcaklık üretsin istediğim için böyle yaptım.
		
		// -> FactoryMethod Tasarımı için
		// Sıcaklık 40 derecenin üstünde ise admine uyarı mesajı gönderiliyor. (admin=mehmetyksl)
		if(uretilen>=40)
		{
			var mesajFactory = new mesajFactory();
			mesajFactory.MesajGonder(uretilen);
		}
		
		
		// -> Observer Tasarımı için
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
