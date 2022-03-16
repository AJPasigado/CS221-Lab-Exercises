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
    	int cases = input.nextInt();
    	input.nextLine();
    	int[] ans = new int[cases];
    	for (int i=0; i<cases;i++){
    		int n = input.nextInt(); input.nextLine();
    		int r = input.nextInt(); input.nextLine();
    		ans[i] = (Factorial(n)/(Factorial(r)*Factorial(n-r)));
    	}
    	for (int i=0; i<ans.length; i++){
    		System.out.println (ans[i]);
    	}
    }
    
    public static int Factorial (int a){
    	int ret;
    	if (a==0) ret = 1;
    	else ret =  a*Factorial(a-1);
    	return ret;
    }
    
    
}