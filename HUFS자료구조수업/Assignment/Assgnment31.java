import java.io.*;
import java.util.Scanner;

class Polynomial {
	private int[][] term;
	private int curNoTerm = 0;

	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}

	public Polynomial() {
		this(20);  // default로 최대 20개의 항을 저장함
	}

	/**
	 * @param coef 계수
   * @param exp 지수
	 */
	public void addTerm(int coef, int exp) {
		term[curNoTerm][0] = exp;      //
		term[curNoTerm][1] = coef;
		curNoTerm++;
	}

	// @param exp
	// 작성하시오
	public void delTerm(int exp) {

		for(int i=0; i<curNoTerm-1; i++){
			term[i] = term[i+1];
		}
		curNoTerm--;
	}

	/**
	 * 출력할 때 사용
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
	 * 작성하시오.
	 */
	public String toString() {
		String answer = "";
		if(curNoTerm !=0) {
			for(int i =0 ; i<curNoTerm; i++){
				if(term[i][0]==0){
					answer += term[i][1];
				}else {
					if(term[i][0]==1){
						if(term[i][1]==1){
							answer += "x";
						}else {
							answer += term[i][1] + "x";
						}
						
					}else {
						if(term[i][1]==1){
							answer +="x";
						}else {
							answer += term[i][1] + "x^"+term[i][0];
						}
						
				
					}
				}
				if(i != curNoTerm-1) {
					answer += "+";
				}
			}
		}else {
			answer += "0";
		}
		
		
		return answer;
	}

	/**
	 * 두 개의 다항식을 더한다.
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 * 작성할 것 
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Polynomial p3 = new Polynomial();
		while(!(p1.curNoTerm==0) || !(p2.curNoTerm==0) ){
			if(p1.curNoTerm ==0 || p2.curNoTerm ==0) {
				if(p1.curNoTerm ==0 && p2.curNoTerm!=0) {
					p3.addTerm(p2.term[0][1],p2.term[0][0]);
					p2.delTerm(p2.term[0][0]);
				}else if(p2.curNoTerm==0 && p1.curNoTerm!=0) {
					p3.addTerm(p1.term[0][1],p1.term[0][0]);
					p1.delTerm(p1.term[0][0]);
				}
			}else {
				if(p1.term[0][0] > p2.term[0][0]){
					p3.addTerm(p1.term[0][1],p1.term[0][0]);
					p1.delTerm(p1.term[0][0]);
				}else if(p1.term[0][0] == p2.term[0][0]){
					int num = p1.term[0][1]+p2.term[0][1];
					if( num !=0){
						p3.addTerm(num,p1.term[0][0]);
						p1.delTerm(p1.term[0][0]);
						p2.delTerm(p2.term[0][0]);
					}else {
						p1.delTerm(p1.term[0][0]);
						p2.delTerm(p2.term[0][0]);
					}
				}else{
					p3.addTerm(p2.term[0][1],p2.term[0][0]);
					p2.delTerm(p2.term[0][0]);
				}
			}
			
			
		}
		return p3;
	}
}

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 첫번째 다항식 입력
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p1.addTerm(coef, exp);
		}


		Polynomial p2 = new Polynomial();
		// 두번째 다항식 입력 코드 여기에 작성할 것
		int no2 = scan.nextInt();
		for(int i =0; i<no2; i++){
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p2.addTerm(coef,exp);
		}






		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // 이것은 System.out.print(p3.toString())과 동일
	}
}