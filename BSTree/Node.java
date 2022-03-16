
/*	BSTree Node
 *	Anton John B. Pasigado
 *	09/06/2016
 *	References: None
 */


public class Node {

    	public int data;
    	public Node left;
    	public Node right;
    
    	public Node (int a){
    		this(a, null, null);
    	}
    	
    	public Node (int a, Node e, Node c){
    		data = a;
    		right = e;
    		left = c;
    	}
    
    
    
}