package akilliCihazProje;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class AkilliCihaz 
{

	private final IEkran ekran;
	private final ITusTakimi tusTakimi;
	private final IAgArayuzu agArayuzu;
	private final ISicaklikAlgilayici sicaklikAlgilayici;
	private final IEyleyiciModul eyleyiciModul;
	
	Menu menu=new Menu();
	IVeriTabani postgreSql=new PostgreSqlVeriTabani();
	
	public AkilliCihaz()
	{
		ekran=new Ekran();
		tusTakimi=new TusTakimi();
		agArayuzu=new AgArayuzu();
		sicaklikAlgilayici=new SicaklikAlgilayici();
		eyleyiciModul=new EyleyiciModul();
	}
	
	public void basla() 
	{
		int yetki=0; // 0 ise yetkisiz, 1 ise yetkili
		int sifreDogrulama=0;
		int yetkiDogrulama=0;
		String kAdi="",sifre="";
		Scanner scan=new Scanner(System.in);
		
		ekran.mesajGoruntule("Kullan�c� Ad�: ");
		kAdi=tusTakimi.veriAl();
		//kAdi=scan.next();scan.nextLine();
		
		ekran.mesajGoruntule("\n�ifre: ");
		sifre=tusTakimi.veriAl();
		//sifre=scan.next();scan.nextLine();
		
		ekran.mesajGoruntule("\nDo�rulama Yap�l�yor...");
		
		IAkilliCihazSistemi akilliCihazSistemi=new AkilliCihazSistemi();
		int kullaniciAdiDogrulama=akilliCihazSistemi.kullaniciAdiDogrula(kAdi);
		// kullaniciAdiDogrulama=0 ise dogrulanamad�,
		// kullaniciAdiDogrulama=1 ise do�ruland�.
		
		if(kullaniciAdiDogrulama==1) // kullaniciAdi dogruysa sifresine bakmaliyiz.
		{
			sifreDogrulama=akilliCihazSistemi.sifreDogrula(sifre);
			// sifreDogrulama=0 ise dogrulanamad�,
			// sifreDogrulama=1 ise do�ruland�.
		}
	
		
		if(kullaniciAdiDogrulama==1 && sifreDogrulama==1) // kullaniciAdi ve Sifre Dogru ise i�lemlerimize devam edebiliriz.
		{
			ekran.mesajGoruntule("\nKullan�c� Yetkisi Kontrol Ediliyor...");
			// kullan�c�n�n yetkisini bulal�m elimizde olsun. Ona g�re ana men� listelenecek.
			
			//---Baglant�y� ald�k ve Kullan�c�n�n yetkisini bulduk
			java.sql.Connection connect=null;
			connect=postgreSql.baglan();
			yetkiDogrulama=postgreSql.yetkiDogrula(kAdi, connect);

			if(yetkiDogrulama==1) // yetki=1 ise YetkiliKullan�c�'d�r.
			{
				// YETK�L� KULLANICI ���N 4 ��LEM TANIMLI. 
				// Proje Tasar�m�- Cihaz �al��mas� adl� Pdf, 10.Madde :
				// YETK�L� KULLANICILAR alg�lay�c�dan gelen s�cakl��� g�r�nt�leyebilmeli ve so�utucuyu a��p kapatabilmelidir.
				
				ekran.mesajGoruntule("Yetkili Kullan�c�...");
				yetki=1;
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
					
					ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri al�yor. �lk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam m�:? "+devam);
						ekran.mesajGoruntule("��leminizi Se�iniz:");
						
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // ��k�� Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
					
				
				}
				else if(secim==2)
				{
					ekran.mesajGoruntule("��leminiz yap�l�yor...");
					agArayuzu.sogutucuyuAc();
					
					ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri al�yor. �lk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam m�:? "+devam);
						ekran.mesajGoruntule("��leminizi Se�iniz:");
					
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // ��k�� Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				else if(secim==3)
				{
					ekran.mesajGoruntule("��leminiz yap�l�yor...");
					agArayuzu.sogutucuyuKapat();
					
					ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri al�yor. �lk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam m�:? "+devam);
						ekran.mesajGoruntule("��leminizi Se�iniz:");
					
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // ��k�� Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				else if(secim==4)
				{
					ekran.mesajGoruntule("��leminiz yap�l�yor...");
					agArayuzu.cikis();
				}
			}
			else
			{
				// YETK�S�Z KULLANICI ���N 2 ��LEM TANIMLI. 
				// Proje Tasar�m�- Cihaz �al��mas� adl� Pdf, 10.Madde :
				// YETK�L� KULLANICILAR alg�lay�c�dan gelen s�cakl��� g�r�nt�leyebilmeli ve so�utucuyu a��p kapatabilmelidir.
				// Bu durumda YETK�S�Z KULLANICILAR s�cakl�k �l�ebilirler.
				
				ekran.mesajGoruntule("Yetkisiz Kullan�c�...");
				yetki=0;
				ekran.mesajGoruntule("\n*********** MEN� ***********");
				ekran.mesajGoruntule("1-S�cakl�k �l�");
				ekran.mesajGoruntule("2-��k��");
				ekran.mesajGoruntule("Se�iminiz(1-2 aras�nda): ");
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
					//ekran.mesajGoruntule("S�cakl�k: "+sicaklik);
					System.out.println("S�cakl�k �l�me ��lemi Ger�ekle�ti.\nNOT: S�cakl�k G�r�nt�lemesi Yaln�zca 'YETK�L� KULLANICI'lar Taraf�ndan "
							+ "Yap�labilir.");
					
					ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri al�yor. �lk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam m�:? "+devam);
						ekran.mesajGoruntule("��leminizi Se�iniz:");
						menu.menuYetkisiz(ekran, tusTakimi, agArayuzu, sicaklikAlgilayici);
						
						ekran.mesajGoruntule("\nSistemden ��k�� Yapmak �ster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // ��k�� Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				if(secim==2)
				{
					ekran.mesajGoruntule("��leminiz yap�l�yor...");
					agArayuzu.cikis();
				}
			}
		}
		}
		
	} //------->basla() biti�i
	
