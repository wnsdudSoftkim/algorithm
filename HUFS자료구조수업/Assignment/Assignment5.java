import java.io.*;
import java.util.Scanner;
import java.util.Stack;
class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack<String> operator = new Stack<String>();
		Stack<String> answer = new Stack<String>();
		int count=0;
		int answercount=0;
		// 아래 코드를 작성하시오.
		String str = scan.next();
		while (!str.equals("$")) {
			if(str.equals(")")) {
				answer.push(operator.pop());
				answercount++;
			}else if(str.equals("*") ||str.equals("+")||str.equals("-")||str.equals("/")) {
				operator.push(str);
				count++;
			}
			else {
				answer.push(str);
				answercount++;
			}
			
			
			str = scan.next();
		}
		for(int i=0; i<count; i++) {
			answer.push(operator.pop());
			answercount++;
		}
		for(int i=0; i<answercount; i++) {
			System.out.print(answer.pop());
		}
	}
}