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
class java4 {
    public static void main(String[] args) {
        
    }
    
}
//일반 행렬의 전치
class Matrix{
    private int m;
    private int n;
    private int[][] a;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        a = new int[m][n];

    }
    public void set(int i , int j, int value) {
        a[i][j] = value;
    }
    public int get(int i , int j) {
        return a[i][j];
    }
    public Matrix transpose() {
        Matrix mat = new Matrix(n,m);
        for(int i = 0; i<=n-1; i++) {
            for(int j =0; j<m-1; m++) {
                mat.a[i][j] = a[j][i];
            }

        }
        return mat;
    }
    //희소 행렬의 전치
    public matrix transposeS() {
        
    }

}

