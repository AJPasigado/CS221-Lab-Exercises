
/*  BSTree
 *  Anton John B. Pasigado
 *  09/16/2016
 *  References: None
 */
 
 import java.util.LinkedList;
 
 public class BSTree {
    private Node root;
    private int height;
        
    public BSTree () {
        root=null;
    }
    
    public boolean isEmpty(){
        if (root == null) return true;
        return false;
    }
    
    public void insert (int a){
        if (isEmpty()){root = new Node(a);} 
        else {  Node temp = root; int htemp = 0; boolean inserted = false;
                while (inserted == false){
                    if (a < temp.data){
                        if (temp.left == null){temp.left = new Node (a); inserted = true;} 
                        else temp = temp.left;
                    } else if (a > temp.data){
                        if (temp.right == null){temp.right = new Node (a); inserted = true;} 
                        else temp = temp.right;
                    } htemp++;
                }
                if (htemp > height){height = htemp; balanceTree();}      
        }
    }
    
    public int getHeight(){
        return height;
    }
    
    public void bfs(){
        LinkedList<Node> Ln = new LinkedList<Node>();
        Node temp = root;
        System.out.println ("BFS: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            if (temp.left !=null) Ln.addLast(temp.left);
            if (temp.right !=null) Ln.addLast(temp.right);
            if (Ln.size()!=0) temp = Ln.remove();
            else temp = null;
        }
    }
    
    public void preorder(){         //VLR
        vlr(root);
    }
    
    private void vlr(Node temp){
        System.out.print (temp.data + " ");
        if (temp.left!=null) vlr(temp.left);
        if (temp.right!=null) vlr (temp.right);
        else return;
    }
    
    public void inorder(){
        lvr(root);
    }
    
    private void lvr(Node temp){
        if (temp!=null) {
            lvr(temp.left);
            System.out.print (temp.data + " ");
            lvr (temp.right);
        } else return;
    }
    
    public void postorder(){
        lrv(root);
    }
    
    private void lrv(Node temp){
        if (temp!=null) {
            lrv(temp.left);
            lrv (temp.right);
            System.out.print (temp.data + " ");
        } else return;
    }
    
    public void delete(int a){
        if (root.data == a){                //deleting at roots 
            if (root.left == null && root.right != null){root = root.right;}
            else if (root.left != null && root.right == null){root = root.left;}
            else if (root.left != null && root.right != null){deleteRoot(root);}
            else if (root.left == null && root.right == null) {root = null;}
        } else{ Node temp = getPrevious(a);
                if (temp.left.data == a){
                    if (temp.left.left == null && temp.left.right == null) temp.left = null;
                    else if (temp.left.left == null || temp.left.right == null) deleteOneChild(temp);
                    else if (temp.left.left != null || temp.left.right != null) deleteTwoChild(temp, "Left");
                } else if (temp.right.data == a){
                    if (temp.right.left == null && temp.right.right == null) temp.right = null;
                    else if (temp.right.right == null || temp.right.left == null) deleteOneChild(temp);
                    else if (temp.right.left != null || temp.right.right != null) deleteTwoChild(temp, "Right");
                }
        }
        balanceTree(); height = updateHeight(root);
    }
    
    private void deleteOneChild(Node temp){ //delete a node with one child
        if (temp.left.left != null){temp.left = temp.left.left;} 
        else if (temp.left.right != null){temp.left = temp.left.right;} 
        else if (temp.right.right != null){temp.right = temp.right.right;} 
        else if (temp.right.left != null){temp.right = temp.right.left;}
    }
    
    private void deleteTwoChild(Node temp, String pos){ //delete a node with two children       // DeleteNode using copying
        Node rightmost = null; int data = 0;
        if (pos == "Right")                                             //scans where to get the rightmost
            if (temp.right.left == null) rightmost = temp.right;
            else rightmost = temp.right.left;
        else if (pos == "Left")
            if (temp.left.left == null) rightmost = temp.left;
            else rightmost = temp.left.left;
        while(rightmost.right!=null){rightmost = rightmost.right;}      //get the rightmost
        if (rightmost.left == null){
            if (getPrevious(rightmost).right == rightmost){getPrevious(rightmost).right = null;}
            else if (getPrevious(rightmost).left == rightmost){getPrevious(rightmost).left = null;} 
        } else if (rightmost.left !=null){
            getPrevious(rightmost).right = rightmost.left;
        }
        if (pos == "Right")temp.right.data = rightmost.data;
        else if (pos == "Left")temp.left.data = rightmost.data;
    }
    
    private Node getPrevious(Node temp){
        return getPrevious(temp.data);
    }
    
    private Node getPrevious(int a){        //get the previous Node of temp
        Node tempy = root;     
        while (tempy!=null){    
            if (tempy.left == null && tempy.right != null){
                if (tempy.right.data == a) break;
            } else if (tempy.left != null && tempy.right == null){
                if (tempy.left.data == a) break;
            } else if (tempy.left !=null && tempy.right != null){
                if (tempy.right.data == a) break;
                if (tempy.left.data == a) break;
            }
            if (a < tempy.data){tempy = tempy.left;} 
            else if (a > tempy.data){tempy = tempy.right;}
        }
        return tempy;
    }
    
    private void deleteRoot(Node temp){ // DeleteRoot using merge
        Node rightmost = temp.left;
        while(rightmost.right!=null){rightmost = rightmost.right;}      //getRightmost
        rightmost.right = temp.right;
        root = temp.left;
    }
     
    public void balanceTree(){
        LinkedList<Node> Ln = new LinkedList<Node>();
        getSortedList(Ln, root);
        root = null;
        insertList(Ln, 0, Ln.size()-1);
        height = updateHeight(root);
    }
    
    private void insertList(LinkedList<Node> Ln, int low, int high){
        if (low>high) return;
        insert (Ln.get((low+high)/2).data);
        insertList(Ln, low, ((low+high)/2)-1);
        insertList(Ln, ((low+high)/2)+1, high);
    }
    
    private void getSortedList(LinkedList<Node> Ln, Node temp){
        if (temp!=null) {
            getSortedList(Ln, temp.left);
            Ln.addLast(temp);
            getSortedList(Ln, temp.right);
        } else return;
    }
    
    private int updateHeight(Node temp){
        if (temp == null) return -1;
        else{   int left = updateHeight(temp.left);
                int right = updateHeight(temp.right);
                if (left > right) return left+1;
                else return right+1;
        }
    }
}