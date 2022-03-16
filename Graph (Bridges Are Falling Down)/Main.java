
/*  Bridges Are Fallig Down
 *  Anton John B. Pasigado
 *  09/25/2016
 *  References: None
 */

import java.util.Scanner;

public class Main {
    
    public static void main (String[] args){
        Scanner input = new Scanner (System.in);
        Bridge mg = new Bridge();
        
        System.out.println ("Insert: ");
        int count = input.nextInt();
        
        for (int i=0; i<count; i++){
	    String a = input.next().toUpperCase();
            String b = input.next().toUpperCase();
            mg.addAnEdge(a, b);
		mg.addAnEdge(b, a);
        }
        
        System.out.println (mg.getSpan());
    }
}