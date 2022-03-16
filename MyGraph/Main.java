
/*	myGraph Main
 *	Anton John B. Pasigado
 *	09/20/2016
 *	References: None
 */


public class Main {
	
	public static void main (String[] args){
		myGraph mg = new myGraph();
		
		mg.addNode(3);
    	mg.addNode(5);
    	mg.addNode(1);
    	mg.addEdge(5, 3);
    	mg.addEdge(5, 1);
    	mg.addEdge(5, 5);
    	mg.addEdge(5, 1);
    	mg.addEdge(5, 1);
    	mg.print();
	}
}