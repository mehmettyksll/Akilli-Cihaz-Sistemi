package akilliCihazProje;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi {

    public String veriAl()
    {
    	String deger;
        Scanner input=new Scanner(System.in);
        deger=input.next(); input.nextLine();
        return deger;
    }
    
    public int degerAl()
    {
    	Scanner input=new Scanner(System.in);
    	return input.nextInt();
    }
}