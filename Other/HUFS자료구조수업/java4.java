package Other.HUFS자료구조수업;
// 순차 데이터 표현
// 1. 배열
// 배열의 특성
// 순차적 메모리 할당 방식
//선형리스트 - 원소들을 일렬로 정렬해 놓은것
// 순서를 가진 원소들의 순열
//다항식 추상 데이터 타입
// Polonomial()
// coef(e)
//maxExp()
// addTerm(e)
// delTerm(e)
// multiply(a,e)
// add(p1)
//ex) 2x^3 + 4x^2 +5
//addTerm은 그냥 항을 더하는 함수임
//zeroP는 항을 만들어 주는거
// addTerm(addTerm(addTerm(zeroP(),2,3),4,2),5,0)
//Polonomial p = new Polonomial()
// p.addTerm(2,3)
//p.addTerm(4,2)
//p.addTerm(5,0 )
// class java4 {
//     public static void main(String[] args) {
        
//     }
    
// }
// //일반 행렬의 전치
// class Matrix{
//     private int m;
//     private int n;
//     private int[][] a;

//     public Matrix(int m, int n) {
//         this.m = m;
//         this.n = n;
//         a = new int[m][n];

//     }
//     public void set(int i , int j, int value) {
//         a[i][j] = value;
//     }
//     public int get(int i , int j) {
//         return a[i][j];
//     }
//     public Matrix transpose() {
//         Matrix mat = new Matrix(n,m);
//         for(int i = 0; i<=n-1; i++) {
//             for(int j =0; j<m-1; m++) {
//                 mat.a[i][j] = a[j][i];
//             }

//         }
//         return mat;
//     }
//     //희소 행렬의 전치
//     public matrix transposeS() {
        
//     }

// }
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
    public void delTerm(int exp) {
        int number = 0;
		for(int i=0; i<curNoTerm; i++;){
			if(exp == term[i][0]){
				number = i;
			}
		}
		for(int i=number; i<curNoTerm; i++;){
			term[i] = term[i+1];
		}	
    }
    public String toString() {
        return null;
    }
    public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
		while(!(p1.curNoTerm==0) && !(p2.curNoTerm==0) ){
			if(p1.term[0][0] > p2.term[0][0]){
				p3.addTerm(p1.term[0][1],p1.term[0][0]);
				p1.delTerm(p1.term[0][0]);
			}else if(p1.term[0][0] == p2.term[0][0]){
				int num = p1.term[0][1]+p2.term[0][1];
				if( num !=0){
					p3.addTerm(num,p1.term[0][0]);
				}
			}else{
				p3.addTerm(p2.term[0][1],p2.term[0][0]);
				p2.delTerm(p2.term[0][0]);
			}
	}
	
	return null;

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
        // 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // 이것은 System.out.print(p3.toString())과 동일
	}
}