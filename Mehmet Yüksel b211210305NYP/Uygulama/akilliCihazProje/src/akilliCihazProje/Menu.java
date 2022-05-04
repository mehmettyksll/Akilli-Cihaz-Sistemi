package akilliCihazProje;

public class Menu 
{
	public void menuYetkili(IEkran ekran, ITusTakimi tusTakimi, IAgArayuzu agArayuzu) // kurucusunun icerisinde direk islemlerimizi yapalim
	{
		ekran.mesajGoruntule("\n*********** MEN� ***********");
		ekran.mesajGoruntule("1-S�cakl��� G�r�nt�le");
		ekran.mesajGoruntule("2-So�utucuyu A�");
		ekran.mesajGoruntule("3-So�utucuyu Kapat");
		ekran.mesajGoruntule("4-��k��");
		ekran.mesajGoruntule("Se�iminiz(1-4 aras�nda): ");
		
		int secim=tusTakimi.degerAl(); 
		while(secim!=1 || secim!=2 || secim!=3 || secim!=4) // Se�im 1-4 aras� de�ilse tekrar tekrar se�im yapmas�n� istiyorum.
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
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			agArayuzu.sicaklikGoruntule();
		}
		else if(secim==2)
		{
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			agArayuzu.sogutucuyuAc();
		}
		else if(secim==3)
		{
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			agArayuzu.sogutucuyuKapat();
		}
		else if(secim==4)
		{
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			agArayuzu.cikis();
		}
	}
	
	public void menuYetkisiz(IEkran ekran, ITusTakimi tusTakimi,IAgArayuzu agArayuzu, ISicaklikAlgilayici sicaklikAlgilayici) // kurucusunun icerisinde direk islemlerimizi yapalim
	{
		ekran.mesajGoruntule("\n*********** MEN� ***********");
		ekran.mesajGoruntule("1-S�cakl�k �l�");
		ekran.mesajGoruntule("2-��k��");
		int secim=tusTakimi.degerAl(); 
		while(secim!=1 || secim!=2 ) // Se�im 1 de�ilse tekrar tekrar se�im yapmas�n� istiyorum.
		{
			if(secim==1)
				break;
			if(secim==2)
				break;
			secim=tusTakimi.degerAl(); 
		}
		
		if(secim==1)
		{
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			int sicaklik=sicaklikAlgilayici.sicaklikOlc();
			ekran.mesajGoruntule("S�cakl�k: "+sicaklik);
		}
		if(secim==2)
		{
			ekran.mesajGoruntule("��leminiz yap�l�yor...");
			agArayuzu.cikis();
		}
	}
	
}
