package Other.HUFS자료구조수업;
import java.io.*;
import java.util.Scanner;

class UserStack {
	int size;
	String [] stack;
	int top;
	double answer;
	public UserStack(int size) {
		this.size = size;
		stack = new String[size];
	}
	void push(String item) {
		stack[++top] = item;
		
	}
	void pushindex(double item, int index) {
		stack[index] = ""+item;
	}
	void pop(String item) {
		
		for(int i=0; i<=top; i++) {
			System.out.println(""+stack[i]);
			if(item.equals(stack[i])) {
				stack[i] = stack[i+1];
				top--;
			}
		}
	}
	double calculate() {
		//인덱스 3번째부터 탐색
		int count=0;
		while(true) {
			if(top==0) break;
			if (stack[count].equals("+")) {
				double before = Double.parseDouble(stack[count-2]);
				double after = Double.parseDouble(stack[count-1]);
				answer += before+after;
				pushindex(answer,count);
				pop(stack[count-2]);
				pop(stack[count-1]);
			}
			else if (stack[count].equals("*")) {
				double before = Double.parseDouble(stack[count-2]);
				double after = Double.parseDouble(stack[count-1]);
				answer += before*after;
				pushindex(answer,count);
				pop(stack[count-2]);
				pop(stack[count-1]);
			}
			else if (stack[count].equals("-")) {
				double before = Double.parseDouble(stack[count-2]);
				double after = Double.parseDouble(stack[count-1]);
				answer += before-after;
				pushindex(answer,count);
				pop(stack[count-2]);
				pop(stack[count-1]);
			}
			else if (stack[count].equals("/")) {
				double before = Double.parseDouble(stack[count-2]);
				double after = Double.parseDouble(stack[count-1]);
				answer += before/after;
				pushindex(answer,count);
				pop(stack[count-2]);
				pop(stack[count-1]);
			}
			count++;
		}
		return answer;
	}
}


class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// 아래 코드를 완성하시오.
		String str = scan.next();
		UserStack stack = new UserStack(100);
		while (!str.equals("$")) {
			//100으로 우선 초기화
			
			//string  형변환
			stack.push(""+str);
			str = scan.next();
		}
		System.out.println(stack.calculate());
	}
}