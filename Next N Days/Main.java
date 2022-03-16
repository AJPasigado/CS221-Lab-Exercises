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
    	Scanner input = new Scanner(System.in);
    	
    	int a = input.nextInt();
    	int b = 0, c=0;
    	int[] ans = new int[a];
    	for (int i=0; i<a; i++){
    		b = input.nextInt()-1;
    		c = input.nextInt()-1;
    		ans[i] = (((b+c)+1)%7);	
    	}
    	for (int i=0; i<a; i++){
    		if (ans[i]==0){
    			System.out.println ("Sunday");
    		} else if (ans[i]==1){
    			System.out.println ("Monday");
    		} else if (ans[i]==2){
    			System.out.println ("Tuesday");
    		}else if (ans[i]==3){
    			System.out.println ("Wednesday");
    		}else if (ans[i]==4){
    			System.out.println ("Thursday");
    		}else if (ans[i]==5){
    			System.out.println ("Friday");
    		}else if (ans[i]==6){
    			System.out.println ("Saturday");
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
}