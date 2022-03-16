/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2016/11/23
 */

import java.util.*;

public class Main {

    public static void main (String [] args){
    	Scanner input = new Scanner (System.in);
    	int a = input.nextInt();
    	
    	for (int i=0; i<a-1; i++){
    		for (int k=i; k<a-1; k++){
    			System.out.print (" ");
    		}
    		for (int j=0; j<i+1; j++){
    			System.out.print ("* ");
    		}
    		System.out.println ();
    	}
    	
    	for (int i=0; i<a; i++){
    		System.out.print ("* ");
    	}
    	System.out.println ();
    	
    	for (int i=a-1; i>0; i--){
    		for (int k=a; k>i; k--){
    			System.out.print (" ");
    		}
    		for (int j=i+1; j>1; j--){
    			System.out.print ("* ");
    		}
    		System.out.println ();
    	}
    	
    	
    	
    	
    	
    	
    }
    
    
}