
/*	myGraph Node
 *	Anton John B. Pasigado
 *	09/20/2016
 *	References: None
 */

import java.util.ArrayList;

public class Node {

    	public int data;
    	ArrayList<Integer> neighbors = new ArrayList<Integer>();
    	
    	public Node (int a){
    		data = a;
    	}
    	
    	public void addNeighbor(int a){
    		neighbors.add(a);
    	}
    	
    	public ArrayList<Integer> getNeighbors(){
    		return neighbors;
    	}
}