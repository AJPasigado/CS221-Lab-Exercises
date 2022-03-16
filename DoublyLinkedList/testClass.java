import java.util.*;
public class testClass {

	public static void main(String[] args) {
		int counter=25,x;
		DoublyLinkedList sLL= new DoublyLinkedList();
		Random ran = new Random();
		int[] valueSHITS=new int[50];
		System.out.print("Your numbers: ");
		for(x=0;counter*2>x;x++)
		{
			valueSHITS[x]=ran.nextInt(100);
			System.out.print(valueSHITS[x]+" ");
		}
		for(x=0;counter>x;x++)
		{
			sLL.addToHead(valueSHITS[24-x]);
			sLL.addToTail(valueSHITS[x+25]);
			//creates 50 nodes, to head and tail in that order
		}
		sLL.print();
		System.out.println("\nNode Creation: Success");
		if(sLL.size()==50)
			System.out.println("Size Check: Success");
		else
			System.out.println("Size Check: Fail");
		
		if(sLL.deleteHead()==valueSHITS[0])
			System.out.println("deleteHead() Check: Success");
		else
			System.out.println("deleteHead() Check: Fail");
		
		if(sLL.deleteTail()==valueSHITS[49])
			System.out.println("deleteTail() Check: Success");
		else
			System.out.println("deleteTail() Check: Fail");
		
		if(sLL.remove(valueSHITS[20]))
			System.out.println("Single Remove Check: Success");
		else
			System.out.println("Single Remove Check: Fail");
		
		if(sLL.indexOf(valueSHITS[14])==13)
			System.out.println("Indexing Check: Success");
		else
			System.out.println("Indexing Check: Fail");
		//Everything after will rely on indexing as a working method
		sLL.set(2,3);
		
		if(sLL.indexOf(3)==2)
			System.out.println("Setting Check: Success");
		else
			System.out.println("Setting Check: Fail");
		
		sLL.insert(2,14);
		
		if(sLL.indexOf(3)==3&&sLL.indexOf(14)==2)
			System.out.println("Insert Check: Success");
		else
			System.out.println("Insert Check: Fail");
		
		if(sLL.delete(2)==14)
			System.out.println("Index Delete: Success");
		else
			System.out.println("Index Delete: Fail");
		
		sLL.set(3,3);
		sLL.set(4,3);
		sLL.set(5,3);
		
		if(sLL.removeAll(3)&&sLL.indexOf(3)==-1)
			System.out.println("Remove All: Success");
		else{
			sLL.print();
			System.out.println("Remove All: Fail");
		}
	}

}
