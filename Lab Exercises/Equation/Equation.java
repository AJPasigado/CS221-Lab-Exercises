/**
 * Equation
 * Anton John B. Pasigado
 * 08/28/2016
 * References: None
 */

import java.util.Stack;

public class Equation {
	public static void main (String[] args){
		System.out.println (Equation.isValid("(()[][][][][X+Y][][][]{{}})"));
	}
	
	public static boolean isValid (String a){
		Stack <String> stack = new Stack<String>();
		
		for (int i=0; i<a.length(); i++){
			String c = Character.toString(a.charAt(i));
			if 			(	stack.empty() == false 							&&	(
						(	c.equals("}") && stack.peek().equals("{")) 		||
						(	c.equals("]") && stack.peek().equals("["))		||
						(	c.equals(")") && stack.peek().equals("(")) 		))	{stack.pop();} 
			else if 	(	c.equals("}") || c.equals("]") || c.equals(")") || 
							c.equals("{") || c.equals("[") || c.equals("(")	)	{stack.push(c);}
		}
		
		return stack.empty();
	}
}