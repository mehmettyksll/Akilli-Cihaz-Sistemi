package akilliCihazProje;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici
{
	public int sicaklikOlc()
	{
		Random rastgele = new Random();
		int sayi = rastgele.nextInt(41); // 0-40 aras� say� �retir. 
		int uretilen=sayi-20; // -20 ile +20 aras�nda s�cakl�k �retsin istedi�im i�in b�yle yapt�m.
		return uretilen;
	}
}
