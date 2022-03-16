/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2016/11/23
 */
import java.util.*;

public class Main {

    public static void main (String[]args){
    	Scanner input = new Scanner (System.in);
    	
    	int a = input.nextInt();
    	input.nextLine();
    	int[] ans = new int[a];
    	for (int i=0; i<a; i++){
    		input.nextLine();
    		String num = input.nextLine();
    		int output =0;
    		for (int j=0; j<num.length(); j++){
    			String b = num.charAt(j)+"";
    			output = output + Integer.parseInt(b);
    		} ans[i] = output;
    	}
    	
    	for (int i=0; i<a; i++){System.out.println (ans[i]);}
    }
    
    
}