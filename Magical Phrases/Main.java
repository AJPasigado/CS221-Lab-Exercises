/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2016/11/23
 */

import java.util.*;

public class Main {

    public static void main (String[] args){
    	Scanner input = new Scanner (System.in);
    	int a = input.nextInt();
   		input.nextLine();
    	String[] ans = new String[a];
    	for (int i=0; i<a; i++){
    		input.nextLine();
    		String c = input.nextLine().toUpperCase().replace(" ", "");
    		int vowels = 0, cons=0;
    		for (int j=0; j<c.length(); j++){
    			if (c.charAt(j)=='A' ||c.charAt(j)=='E' ||
    				c.charAt(j)=='I' || c.charAt(j)=='O' ||
    				c.charAt(j)=='U'){
    					vowels++;
    				} else cons++;
    			if (vowels < cons){
    				ans[i] = "NOT MAGICAL";
    			} else ans[i] = "MAGICAL";
    		} 
    	}
    	for (int i=0; i<ans.length; i++){
    		System.out.println (ans[i]);
    	}
    
    }
}
    
    
