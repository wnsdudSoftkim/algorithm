package HUFS자료구조수업.Assignment;

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
		/**
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	
	/**
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public int count=0;
	public void insert(String str) {
		ListNode Node = new ListNode();
		Node.data = str;
		Node.llink = Node.rlink = Node;
		if(head==null) {
			head = tail = Node;
			tail.rlink =null;
			head.rlink = null;
		}else {
			tail.rlink = Node;
			tail = Node;
			tail.rlink = null;
		}
		count++;
		sort();
	}

	public void sort() {
		String[] myArray = new String[count];
		ListNode p = head;
		for(int i=0; i<count; i++) {
			if(p==null) break;
			myArray[i] = p.data;
			p=p.rlink;
		}
		for(int i=0; i<count-1; i++) {
			if(((int)myArray[i].charAt(0)) < ((int)myArray[i+1].charAt(0))) {
				String temp = myArray[i];
				myArray[i] = myArray[i+1];
				myArray[i+1] = temp;
			}
				
		}
		for(int i=0; i<count; i++) {
			if(p==null) break;
			p.data = myArray[i];
			p=p.rlink;
		}
	}

	/**
	 * @param str 삭제하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public void delete(String str) {
		ListNode p = head;
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
			System.out.print(p.data);
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