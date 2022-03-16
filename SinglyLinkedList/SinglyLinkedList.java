/*  L.05 Singly Linked List Implementation
 *  Anton John B. Pasigado
 *  07/18/2016
 *  References: None
 */


public class SinglyLinkedList{
    private Node head;
    private Node tail;
    private int count = 0;
        
    public static void main (String[]args){
        SinglyLinkedList p = new SinglyLinkedList ();
        
        p.addToTail(5);
        p.addToTail(6);
        p.addToTail(7);
        p.addToHead(4);
        p.addToHead(3);
        p.addToHead(2);
        
        p.deleteTail();
        p.deleteTail();
        p.deleteTail();
        p.print();
        
        
    }
        
    public SinglyLinkedList () {
        head=tail=null;
    }
    
    public boolean isEmpty(){
        boolean Res = false;
        
        if (head==null && tail == null) 
            Res = true;
            
        return Res; 
    }
    
    public void print(){
        if (isEmpty()==false){
            for (Node temp = head; temp!=null; temp=temp.next){
                System.out.print(temp.data + " ");
            }
        }   
    }
    
    public boolean isExists(int a){
        boolean Res = false;
        if (isEmpty()==false){
            for (Node temp = head; temp!=null; temp=temp.next){
                if (temp.data == a) Res=true;
            }
        }
        return Res; 
    }
    
    public void addToHead(int a){
        head = new Node (a, head);
    }
    
    public void addToTail(int a){
        if (isEmpty()==false){
            tail.next = new Node (a );
            tail=tail.next;
        } else if (isEmpty()== true){
            tail = head = new Node (a);
        }
    }
    
    public int deleteHead(){
        int temp = head.data;
    
        if (head.next!=null){
            head=head.next;
        } else if (head.next==null){
            head=null;
        }
        
        return temp;
    }
    
    public int deleteTail(){
        int tcount = size();
        Node h = head;
        int rem = 0;
        if (tcount>1){
            for(int i=1; i<tcount; i++){
                if(i==tcount-1){
                    rem = h.data;
                    tail = h;
                    tail.next = null;
                } else h = h.next;
            }
        } else if (tcount == 1){
            head=tail=null;
        } 
        return rem;
    }
    
    public int size(){
        int temp = 0; 
        for (Node x = head; x!=null; x=x.next){
            temp++;
        }
        return temp;
    }
}