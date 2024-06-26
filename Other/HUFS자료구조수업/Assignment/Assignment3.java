package Other.HUFS자료구조수업.Assignment;

import java.io.*;
import java.util.Scanner;

class ListNode {
	String data;
	ListNode rlink;
	ListNode llink;
}
class DoubleLinkedList {
	private ListNode head; // 리스트의 첫번째 노드를 가리킴
	private ListNode tail; // 리스트의 마지막 노드를 가리킴

	public DoubleLinkedList() {
		head = tail = null; // 리스트가 비어있을 때는 모두 null 이다.
	}

		/**
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public int count=0;
	String[] array = new String[100];
	public void insert(String str) {
		ListNode p = head;
		ListNode mynode = new ListNode();
		mynode.data = str;
		mynode.llink = mynode.rlink;
		array[count] = str;
		// if(count==0) {
		// 	head=tail=mynode;
		// }else if(count==1) {
		// 	//기존 데이터가 왼쪽
		// 	if(p.data.compareTo(str)<0) {
		// 		p.rlink = mynode.llink;
		// 		tail = mynode;
		// 		tail.rlink = null;
		// 	}else {
		// 		head = mynode;
		// 		head.rlink = p;
		// 		tail = p;
		// 	}
		// }else {
		if(count ==0) head =tail = mynode;
		else {
			for(int i=0; i<=count-1; i++) {
				for(int j= i; j<=count; j++) {
					//앞이 더 크면
					if (array[i].compareTo(array[j])>0) {
						String temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						
					}
				}
			}
			head.data = array[0];
			head.llink =null;
			tail = head;
			for(int i=1; i<=count; i++) {
				ListNode a = new ListNode();
				a.data = array[i];
				a.llink = tail;
				a.llink.rlink = a;
				tail = a;
			}
		}
		
		count ++;
		
	
		
		
		
		
		
		
// 		while(p!=null) {
// 			//p의 데이터가 앞에 있어야 되면
// 			if(p.data.compareTo(mynode.data)<0) {
// 				if(p.rlink ==null) {
// 					p.rlink = mynode.llink;
// 					tail = mynode;
// 					tail.rlink = null;
// 				}else {
// 						mynode.rlink = p.rlink.llink;
// 						p.rlink = mynode.llink;
// 				}
// 			}//p가 뒤에 있어야 되면
// 			else {
// 				if(p.llink == null) {
// 					head=mynode;
// 					head.llink = null;
// 					head.rlink = p;
// 				}else {
// 					p.llink.rlink = mynode.llink;
// 					p.llink = mynode.rlink;
// 				}
				
				
// 			}
// 			p = p.rlink;
// 		}
		
		
		
	}


	/**
	 * @param str 삭제하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public void delete(String str) {
		ListNode p = head;
		if (p== null) return;
		while(true) {
			if(!p.data.equals(str)) {
				p = p.rlink;
			}else break;
		}
		
		if(p ==head ) {
			if(p.rlink ==null) head=null;
			else {
				p.rlink.llink = null;
				head = p.rlink;
			}
		}else if(p.rlink ==null) {
			p.llink.rlink =null;
			tail=p.llink;
		}else {
			p.llink.rlink = p.rlink;
			p.rlink.llink = p.llink;
		}
		int a=0;
		for (int i=0; i<count; i++) {
			if(array[i].equals(str)) {
				a = i;
			}
		}
		for(int i=a; i<count; i++) {
			array[i] = array[i+1];
		}
		count--;
		
	}

	


	// 저장된 모든 데이터를 출력한다.
	public void print() {
		if (head == null) {
			System.out.println("EMPTY");
			return;
		}

		String str = "";
		for(ListNode p = head; p != null; p = p.rlink)
			System.out.print(p.data = " ");
		System.out.println();
	}
}
class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
	
		while (true) {
			String cmd = scan.next();
			if (cmd.equals("E"))
				break;

			if (cmd.equals("I")) {
				list.insert(scan.next());
			} else if (cmd.equals("D")) {
				list.delete(scan.next());
			} else if (cmd.equals("P")) {
				list.print();
			} else {
				System.out.println("ERROR");
			}
		}
	}
}