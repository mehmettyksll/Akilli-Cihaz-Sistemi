package akilliCihazProje;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici
{
	public int sicaklikOlc()
	{
		Random rastgele = new Random();
		int sayi = rastgele.nextInt(41); // 0-40 arasý sayý üretir. 
		int uretilen=sayi-20; // -20 ile +20 arasýnda sýcaklýk üretsin istediðim için böyle yaptým.
		return uretilen;
	}
}
