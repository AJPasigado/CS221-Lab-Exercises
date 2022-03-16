/*	L.06 Doubly Linked List Implementation
 *	Anton John B. Pasigado
 *	07/25/2016
 *	References: None
 */


public class Node {

    	public int data;
    	public Node next;
    	public Node prev;
    
    	public Node (int a){
    		this(a, null, null);
    	}
    	
    	public Node (int a, Node e, Node c){
    		data = a;
    		next = e;
    		prev = c;
    	}
    
    
    
}