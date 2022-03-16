/*	Bridges Are Falling Down Node
 *	Anton John B. Pasigado
 *	09/25/2016
 *	References: None
 */

import java.util.ArrayList;

public class Node {
    	public String data;
    	ArrayList<Integer> neighbors = new ArrayList<Integer>();
    	ArrayList<Integer> weight = new ArrayList<Integer>();
    	
    	public Node (String a){
    		data = a;
    	}
    	
    	public void addNeighbor(int a){
    		neighbors.add(a);
    	}

		public void addWeight(int a){
    		weight.add(a);
    	}
    	
    	public ArrayList<Integer> getNeighbors(){
    		return neighbors;
    	}

		public ArrayList<Integer> getWeight(){
    		return weight;
    	}
}