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
		
		ekran.mesajGoruntule("Kullanýcý Adý: ");
		kAdi=tusTakimi.veriAl();
		//kAdi=scan.next();scan.nextLine();
		
		ekran.mesajGoruntule("\nÞifre: ");
		sifre=tusTakimi.veriAl();
		//sifre=scan.next();scan.nextLine();
		
		ekran.mesajGoruntule("\nDoðrulama Yapýlýyor...");
		
		IAkilliCihazSistemi akilliCihazSistemi=new AkilliCihazSistemi();
		int kullaniciAdiDogrulama=akilliCihazSistemi.kullaniciAdiDogrula(kAdi);
		// kullaniciAdiDogrulama=0 ise dogrulanamadý,
		// kullaniciAdiDogrulama=1 ise doðrulandý.
		
		if(kullaniciAdiDogrulama==1) // kullaniciAdi dogruysa sifresine bakmaliyiz.
		{
			sifreDogrulama=akilliCihazSistemi.sifreDogrula(sifre);
			// sifreDogrulama=0 ise dogrulanamadý,
			// sifreDogrulama=1 ise doðrulandý.
		}
	
		
		if(kullaniciAdiDogrulama==1 && sifreDogrulama==1) // kullaniciAdi ve Sifre Dogru ise iþlemlerimize devam edebiliriz.
		{
			ekran.mesajGoruntule("\nKullanýcý Yetkisi Kontrol Ediliyor...");
			// kullanýcýnýn yetkisini bulalým elimizde olsun. Ona göre ana menü listelenecek.
			
			//---Baglantýyý aldýk ve Kullanýcýnýn yetkisini bulduk
			java.sql.Connection connect=null;
			connect=postgreSql.baglan();
			yetkiDogrulama=postgreSql.yetkiDogrula(kAdi, connect);

			if(yetkiDogrulama==1) // yetki=1 ise YetkiliKullanýcý'dýr.
			{
				// YETKÝLÝ KULLANICI ÝÇÝN 4 ÝÞLEM TANIMLI. 
				// Proje Tasarýmý- Cihaz Çalýþmasý adlý Pdf, 10.Madde :
				// YETKÝLÝ KULLANICILAR algýlayýcýdan gelen sýcaklýðý görüntüleyebilmeli ve soðutucuyu açýp kapatabilmelidir.
				
				ekran.mesajGoruntule("Yetkili Kullanýcý...");
				yetki=1;
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
					
					ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri alýyor. Ýlk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam mý:? "+devam);
						ekran.mesajGoruntule("Ýþleminizi Seçiniz:");
						
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // Çýkýþ Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
					
				
				}
				else if(secim==2)
				{
					ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
					agArayuzu.sogutucuyuAc();
					
					ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri alýyor. Ýlk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam mý:? "+devam);
						ekran.mesajGoruntule("Ýþleminizi Seçiniz:");
					
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // Çýkýþ Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				else if(secim==3)
				{
					ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
					agArayuzu.sogutucuyuKapat();
					
					ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri alýyor. Ýlk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam mý:? "+devam);
						ekran.mesajGoruntule("Ýþleminizi Seçiniz:");
					
						menu.menuYetkili(ekran, tusTakimi, agArayuzu);
						
						ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // Çýkýþ Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				else if(secim==4)
				{
					ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
					agArayuzu.cikis();
				}
			}
			else
			{
				// YETKÝSÝZ KULLANICI ÝÇÝN 2 ÝÞLEM TANIMLI. 
				// Proje Tasarýmý- Cihaz Çalýþmasý adlý Pdf, 10.Madde :
				// YETKÝLÝ KULLANICILAR algýlayýcýdan gelen sýcaklýðý görüntüleyebilmeli ve soðutucuyu açýp kapatabilmelidir.
				// Bu durumda YETKÝSÝZ KULLANICILAR sýcaklýk ölçebilirler.
				
				ekran.mesajGoruntule("Yetkisiz Kullanýcý...");
				yetki=0;
				ekran.mesajGoruntule("\n*********** MENÜ ***********");
				ekran.mesajGoruntule("1-Sýcaklýk Ölç");
				ekran.mesajGoruntule("2-Çýkýþ");
				ekran.mesajGoruntule("Seçiminiz(1-2 arasýnda): ");
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
					//ekran.mesajGoruntule("Sýcaklýk: "+sicaklik);
					System.out.println("Sýcaklýk Ölçme Ýþlemi Gerçekleþti.\nNOT: Sýcaklýk Görüntülemesi Yalnýzca 'YETKÝLÝ KULLANICI'lar Tarafýndan "
							+ "Yapýlabilir.");
					
					ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
					char devam=scan.next().charAt(0); // girilen karakteri alýyor. Ýlk karakter
					
					while(devam!='E')
					{	
						System.out.println("Devam mý:? "+devam);
						ekran.mesajGoruntule("Ýþleminizi Seçiniz:");
						menu.menuYetkisiz(ekran, tusTakimi, agArayuzu, sicaklikAlgilayici);
						
						ekran.mesajGoruntule("\nSistemden Çýkýþ Yapmak Ýster Misiniz?(E/H)");
						devam=scan.next().charAt(0); 
					}
					
					if(devam=='E') // Çýkýþ Yapmak istiyorsa:
					{
						agArayuzu.cikis();
					}			
				}
				if(secim==2)
				{
					ekran.mesajGoruntule("Ýþleminiz yapýlýyor...");
					agArayuzu.cikis();
				}
			}
		}
		}
		
	} //------->basla() bitiþi
	
