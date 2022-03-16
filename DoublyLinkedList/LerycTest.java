/* =============================================================================
 *   READ ME FIRST
 * =============================================================================
 * 		HOW TO USE:
 * 		1.) Set head, tail, and count to public. 
 * 			(remember to change them back b4 sumbitting).
 * 		2.) Put in same folder as DoublyLinkedList.java.
 * 		3.) Run.
 */
public class LerycTest {
	public static void main (String args[]) {
		testSize1();
		deleteTest2();
		deleteTest3();
		deleteTest4();
		deleteTest5();
		deleteTest6();
		deleteTest7();
		removeTest8();
		removeTest9();
		//deleteTest10();
		deleteTest11();
	}
	
	public static void testSize1(){
		boolean e=true;
		System.out.println ("--Test 1--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.addToTail(28);
		sll.addToTail(81);
		sll.delete(1);
		if (sll.head.data!=28) {System.out.println("Wrong Head. Expected 28. Your value: "+sll.head.data);e=false;}
		if (sll.tail.data!=28) {System.out.println("Wrong Tail. Expected 28. Your value: "+sll.tail.data);e=false;}
		if (sll.count!=1) {System.out.println("Wrong Count. Expected 1. Your value: "+sll.count);e=false;}
		if (e) System.out.println("Passed");
	}
	public static void deleteTest2(){
		boolean e=true;
		System.out.println ("--Test 2--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.addToHead(1); 
		sll.addToHead(2); 
		sll.addToTail(68);
		sll.addToTail(34);
		sll.deleteTail();  
		sll.deleteTail();
		if (sll.head.data!=2) {System.out.println("Wrong Head. Expected 2. Your value: "+sll.head.data);e=false;}
		if (sll.tail.data!=1) {System.out.println("Wrong Tail. Expected 1. Your value: "+sll.tail.data);e=false;}
		if (sll.count!=2) {System.out.println("Wrong Count. Expected 2. Your value: "+sll.count);e=false;}
		if (e) System.out.println("Passed");
	}
	public static void deleteTest3(){
		boolean e=true;
		System.out.println ("--Test 3--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.addToHead(1); 
		sll.addToHead(2); 
		sll.addToTail(68);
		sll.addToTail(34);
		sll.deleteTail();  
		sll.deleteHead();
		if (sll.head.data!=1) {System.out.println("Wrong Head. Expected 1. Your value: "+sll.head.data);e=false;}
		if (sll.tail.data!=68) {System.out.println("Wrong Tail. Expected 68. Your value: "+sll.tail.data);e=false;}
		if (sll.count!=2) {System.out.println("Wrong Count. Expected 2. Your value: "+sll.count);e=false;}
		if (e) System.out.println("Passed");
	}
	public static void deleteTest4(){
		System.out.println ("--Test 4--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,82);
		if (sll.head.data!=82 || sll.tail.data!=82 || sll.count!=1) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void deleteTest5() {
		System.out.println ("--Test 5--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,82);
		sll.deleteHead();
		if (sll.head!=null || sll.tail!=null || sll.count!=0) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void deleteTest6() {
		System.out.println ("--Test 6--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,82);
		sll.deleteTail();
		if (sll.head!=null || sll.tail!=null || sll.count!=0) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void deleteTest7() {
		System.out.println ("--Test 7--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,82);
		sll.set(0, 124);
		sll.addToTail(18);
		if (sll.head.data!=124 || sll.tail.data!=18 || sll.count!=2) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void removeTest8() {
		System.out.println ("--Test 8--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,2);
		sll.insert(0,2);
		sll.insert(0,2);
		sll.insert(0,2);
		sll.insert(0,2);
		sll.set(2, 3463234);
		sll.removeAll(2);
		
		if (sll.head.data!=3463234 || sll.tail.data!=3463234 || sll.count!=1) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void removeTest9() {
		System.out.println ("--Test 9--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.insert(0,2);
		sll.insert(1,2);
		sll.insert(2,2);
		sll.insert(3,2);
		sll.insert(4,2);
		sll.set(2, 3463234);
		sll.removeAll(2);
		if (sll.head.data!=3463234 || sll.tail.data!=3463234 || sll.count!=1) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void deleteTest10() {
		System.out.println ("--Test 10--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.addToHead(92);
		sll.addToHead(271);
		sll.addToTail(218);
		sll.insert (1,9123);
		sll.set(3, 1284);
		sll.delete(1);
		sll.removeAll(92);
		if (sll.head.data!=271 || sll.tail.data!=1284 || sll.count!=2) System.out.println("FAIL"); else System.out.println("Passed");
	}
	public static void deleteTest11() {
		System.out.println ("--Test 11--");
		DoublyLinkedList sll = new DoublyLinkedList();
		sll.addToHead(92);
		sll.addToHead(271);
		sll.addToTail(218);
		sll.insert (1,9123);
		sll.set(3, 1284);
		sll.delete(1);
		sll.removeAll(92);
		sll.delete(0);
		sll.deleteTail();
		if (sll.head!=null || sll.tail!=null || sll.count!=0) System.out.println("FAIL"); else System.out.println("Passed");
	}
}

