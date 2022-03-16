public class Main {
	
	
	public static void main (String[] args){
    	BSTree bst = new BSTree ();
    	
    	bst.insert(30);
    	bst.insert(20);
    	bst.insert(5);
    	bst.insert(50);
    	bst.insert(45);
    	bst.insert(75);
    	bst.insert(35);
    	
    	bst.insert(10);
    	
    	bst.insert(70);
    	
    	bst.insert(100);
    	bst.bfs();
    	bst.preorder();
    	bst.inorder();
    	bst.postorder();
    }
}