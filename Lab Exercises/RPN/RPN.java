/**
 * RPN
 * Anton John B. Pasigado
 * 09/02/2016
 * References: None
 */
 
 import java.util.Stack;
 
 public class RPN {
 	public static void main (String[]args){
 		System.out.println (Equate("323*/"));
 	}
 	
 	public static int Equate (String a){
 		Stack<Integer> num = new Stack <Integer>();
 		
 		for (int i=0; i<a.length(); i++){
 			String c = Character.toString(a.charAt(i));
 			if (Character.isDigit(a.charAt(i))){
 				num.push(Character.digit(a.charAt(i), 10));
 			} else if (c.equals ("+")){
 				num.push(num.pop() + num.pop());
 			} else if (c.equals ("-")){
 				num.push(num.pop() - num.pop());
 			} else if (c.equals ("/")){
 				num.push(num.pop() / num.pop());
 			} else if (c.equals ("*")){
 				num.push(num.pop() * num.pop());
 			}
 		}
 		return num.peek();
 	}
 }