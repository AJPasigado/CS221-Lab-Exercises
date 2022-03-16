
/*	myGraph
 *	Anton John B. Pasigado
 *	09/20/2016
 *	References: None
 */

import java.util.ArrayList;

public class myGraph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public void addNode (int a){
		nodes.add(new Node(a));
	}
	
	public void addEdge (int a, int b){
		for (int i=0; i<nodes.size(); i++){
			int temp = nodes.get(i).data;
			if (temp == a){
				nodes.get(i).addNeighbor(getIndex(b));
			}
		}                                                                                                                                                                                                                                                                                                      
	}
	
	public int getIndex(int a){
		int ret = 0;
		for (int i=0; i<nodes.size(); i++){
			Node temp = nodes.get(i);
			if (temp.data == a){
				ret = i;
				break;
			}
		}
		return ret;
	}
	
	public void print(){
		
		for (int i=0; i<nodes.size(); i++){
			Node tempy = nodes.get(i);
			ArrayList<Integer> temp = tempy.getNeighbors();
			System.out.print (tempy.data + " ");
			for (int j=0; j<temp.size(); j++){
				System.out.print (nodes.get(temp.get(j)).data + " ");
			}
			System.out.println ();
		}
	}
}