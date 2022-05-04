package akilliCihazProje;

public class Menu 
{
	public void menuYetkili(IEkran ekran, ITusTakimi tusTakimi, IAgArayuzu agArayuzu) // kurucusunun icerisinde direk islemlerimizi yapalim
	{
		ekran.mesajGoruntule("\n*********** MENÜ ***********");
		ekran.mesajGoruntule("1-Sýcaklýðý Görüntüle");
		ekran.mesajGoruntule("2-Soðutucuyu Aç");
		ekran.mesajGoruntule("3-Soðutucuyu Kapat");
		ekran.mesajGoruntule("4-Çýkýþ");
		ekran.mesajGoruntule("Seçiminiz(1-4 arasýnda): ");
		
		int secim=tusTakimi.degerAl(); 
		while(secim!=1 || secim!=2 || secim!=3 || secim!=4) // Seçim 1-4 arasý deðilse tekrar tekrar seçim yapmasýný istiyorum.
		{
			if(secim==1)
				break;
			if(secim==2)
				break;
			if(secim==3)
				break;
			if(secim==4)
				break;
			secim=tusTakimi.degerAl(); 
		}
		
		if(secim==1)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			agArayuzu.sicaklikGoruntule();
		}
		else if(secim==2)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			agArayuzu.sogutucuyuAc();
		}
		else if(secim==3)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			agArayuzu.sogutucuyuKapat();
		}
		else if(secim==4)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			agArayuzu.cikis();
		}
	}
	
	public void menuYetkisiz(IEkran ekran, ITusTakimi tusTakimi,IAgArayuzu agArayuzu, ISicaklikAlgilayici sicaklikAlgilayici) // kurucusunun icerisinde direk islemlerimizi yapalim
	{
		ekran.mesajGoruntule("\n*********** MENÜ ***********");
		ekran.mesajGoruntule("1-Sýcaklýk Ölç");
		ekran.mesajGoruntule("2-Çýkýþ");
		int secim=tusTakimi.degerAl(); 
		while(secim!=1 || secim!=2 ) // Seçim 1 deðilse tekrar tekrar seçim yapmasýný istiyorum.
		{
			if(secim==1)
				break;
			if(secim==2)
				break;
			secim=tusTakimi.degerAl(); 
		}
		
		if(secim==1)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			int sicaklik=sicaklikAlgilayici.sicaklikOlc();
			ekran.mesajGoruntule("Sýcaklýk: "+sicaklik);
		}
		if(secim==2)
		{
			ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
			agArayuzu.cikis();
		}
	}
	
}
