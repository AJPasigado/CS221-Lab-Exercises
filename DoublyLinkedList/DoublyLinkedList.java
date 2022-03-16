/*  L.06 Doubly Linked List Implementation
 *  Anton John B. Pasigado
 *  07/25/2016
 *  References: None
 */


public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int count;
        
    public DoublyLinkedList () {
        head=tail=null;
    }
    
    public boolean isEmpty(){
    	Boolean Res = false;
        if (head==null && tail == null) Res = true;
        return Res; 
    }
    
    public boolean exists(int a){
        boolean Res = false;
        if (isEmpty()==false){
            for (Node temp = head; temp!=null; temp=temp.next)
                if (temp.data == a) Res=true;
        }
        return Res; 
    }
    
    public void addToHead(int a){
        if (isEmpty()==false){
            head = new Node (a, head, null);
            head.next.prev = head;
        } else head=tail= new Node (a);
        count++;
    }
    
    public void addToTail(int a){
        if (isEmpty()==false){
            tail = new Node (a, null, tail);
            tail.prev.next = tail;
        } else if (isEmpty()){
            tail = head = new Node (a);
        }
        count++;
    }
    
    public int deleteHead(){
        int temp = head.data;
    
        if (head.next!=null){
            head=head.next;
            head.prev = null;
            count--;
        } else if (head.next==null){
            head=tail=null;
            count=0;
        }
        
        return temp;
    }
    
    public int deleteTail(){
        int rem = tail.data;
        
        if (size() == 1){
            deleteHead();
        } else if (size()>1){
            tail = tail.prev;
            tail.next = null;
            count--;
        }
        
        return rem;
    }
    
    public int size(){
        return count;
    }
    
   public boolean remove(int a){
        boolean ret  = false;
        
        if (isEmpty() == false && exists(a)){
        	delete(indexOf(a));
        	ret = true;
        }
        
        return ret;
    }
    
    public boolean removeAll (int a){
        boolean ret  = false;
        
        while(exists(a)){
        	remove(a);
        	ret = true;
        }
   
        return ret;
    }
    
    public int indexOf (int a){
        int Res = 0, index = 0;
        boolean non = false;
        
        if (isEmpty()==false){
            for (Node temp = head; temp!=null; temp=temp.next){
                index++;
                if (temp.data == a){
                    Res = index;
                    non = true;
                    break;
                }
            }
            Res--;
        }
        if (non == false){
            Res = -1;
        }
        return Res; 
    }
    
    public void set (int index, int newVal){
        Node temp = head;
        
        if (isEmpty()==false && index<size()){
            for (int i=0; i<=index; i++){
                if (index == i){
                    temp.data = newVal;
                } else
                    temp = temp.next;
            }
        }       
    }
    
    public void insert (int index, int newVal){
        Node temp = head;
        
        if (index==0){
            addToHead(newVal);
        } else if (isEmpty() == false && index==size()){
            addToTail(newVal);
        } else if (isEmpty()==false && index<size()){
            for (int i=0; i<=index; i++){
                if (index-1 == i){
                    temp.next = new Node (newVal, temp.next, temp);
                    count++;
                } else {
                    temp = temp.next;
                }
            }
        }    
    }
    
    public int delete (int index){
        int ret  = 0;
        
        if (isEmpty() == false && index<size()){
			Node temp = head;
            for (int i = 0; i<size(); i++){
                if (i == index){
                	ret = temp.data;
                	if (temp.data == head.data){
                		deleteHead();
                		break;
                	} else if(temp.data == tail.data){
                        deleteTail();
                        break;
                    } else if (temp.next != null){	
                    	temp.data = temp.next.data;
                    	temp.prev = temp.next.prev;     
                        temp.next = temp.next.next;
                        count--;
                        break;
                    }
                } else
                    temp = temp.next;
            }
        }
        
        return ret;
    }
    
    public void print(){
        if (isEmpty()==false){
            System.out.println(" - - - - - - - - -");
            for (Node temp = tail; temp!=null; temp=temp.prev){
                System.out.println(" - " + temp.data);
            }
            System.out.println("Size: " + count);
        }   
    }
    
}