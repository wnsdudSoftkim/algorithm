package Assignment;



public class MiddleTest {
    public static void main(String[] args) {
        System.out.println("john".compareTo("tom"));
    }
}
//덱
//stack 과 Queue의 성질을 종합한 순서리스트

//일반 큐 로직
//한쪽 끝 rear에서는 삽입 만
//또 다른 긑 front에서는 삭제만 하도록 제한되어 있는 유한 순서 리스트이다.
//선입선출
class Queue {
    private Object[] q;
    private int front, rear;
    private int n =10;
    public Queue() {
        q = new Object[n];
        //초기화(공백 큐)
        front = rear = -1;
    }
    public boolean isEmpty() {
        //front 와 rear이 같으면 공백큐니까
        return (front==rear);
    }
    //뒤에 요소 삽입
    public void enqueue(Object item) throws Exception {
        if(rear == n-1) throw new Exception();
        rear +=1;
        q[rear] = item;
        
    }
    //맨 앞에 있는 요소가 빠져나감
    public Object dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        front += 1;
        return q[front];
    }
    public void delete() throws Exception {
        if(isEmpty()) throw new Exception();
        front+=1;
    }
}
//순차 표현의 문제점을 해결하기 위해 배열 q[n]을 원형으로 운영
class CircularQueue {
    private static final int SIZE = 10;
    private Object[] q = new Object[SIZE];
    private int rear = 0;
    private int front = 0;
    public void enqueue(Object item) throws Exception{
        //rear 값이 n-1 다음에 n이 되지않고 다시 0으로 됨
        rear = (rear+1) %SIZE;
        if(front == rear) throw new Exception();
        q[rear] = item;
    }
    //원형큐에서 원소를 삭제하고 반환
    //실제로 front의 공간 하나는 공백으로 있어야 하나. 구현의 편의를 위해 이 공간을 희생.
    public Object dequeue() throws Exception{
        if(front ==rear) throw new Exception();
        front = (front+1)%SIZE;
        return q[front];
    }
}
//배열을 이용한 queue의 구현
class ArrayQueue {
    private int front;
    private int rear;
    private int count;
    private int queueSize;
    private int increment;
    private Object[] itemArray;
    public ArrayQueue() {
        front = 0;
        rear = 0;
        count = 0;
        queueSize = 50;
        increment = 10;
        itemArray = new Object[queueSize];
    }
    public boolean isEmpty() {
        return (count==0);
    }
    public void enqueue(Object x) {
        if(count ==queueSize) queueFull();
        rear = (rear+1) % queueSize;
        itemArray[rear] = x;
        count ++;
    }
    //큐에서 원소를 삭제해서 반환
    public Object dequeue() {
        if(isEmpty()) return null;
        Object item = itemArray[front];
        front = (front+1)%queueSize;
        count--;
        return item;
    }
    public void queueFull() {
        int oldSize = queueSize;
        queueSize+=increment;
        Object[] tempArray = new Object[queueSize];
        for(int i=0; i<count; i++) {
            //임시 배열로 원소들을 그대로 이동
            //여기서 front가 만약 3이면 그게 temparray 0부터 들어가는 것!
            tempArray[i] = itemArray[front];
            front = (front+1)%oldSize;
        }
        itemArray = tempArray; //배열 이름을 변경
        //그래서 다시 여기서 front를 0으로 초기화 해준다.
        front = 0;
        rear = count;
    }
}
//큐를 연결리스트로 표현

class ListQueue {
    private ListNode front;
    private ListNode rear;
    private int count;
    public ListQueue() {
        front = null;
        rear = null;
        count = 0;
    }
    public boolean isEmpty() {
        return (count==0);
    }
    public void enqueue(Object x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = null;
        if(count ==0) {
            front = rear = newNode;
        }
        else {
            rear.link = newNode;
            rear = newNode;
        }
        count++;
    }
    public Object dequeue() {
        if(count ==0) return null;
        Object item = front.data;
        front = front.link;
        //삭제 후 공백 이 된 경우
        if(front==null) rear =null;
        count--;
        return item;
    }
    
}
//스택
//배열을 이용한 스택 구현
class ArrayStack {
    // 톱 원소를 가르키는 인덱스 변수
    private int top;
    private int stackSize;
    private Object[] itemArray;
    private static final int STACK_SIZE = 50;
    private static final int INCREMENT = 10;
    public ArrayStack() {
        top = -1;
        stackSize = STACK_SIZE;
        itemArray = new Object[stackSize];
    }
    public boolean isEmpty() {
        return (top==-1);
    }
    public void push(Object x) {
        if(top == stackSize-1) stackFull();
        itemArray[++top] = x;
    }
    public void stackFull() {
        stackSize+=INCREMENT;
        Object[] tempArray = new Object[stackSize];
        for(int i=0; i<=top; i++) {
            tempArray[i] = itemArray[i];

        }
        itemArray = tempArray;
    }
    public Object pop() {
        if(isEmpty()) return null;
        else return itemArray[top--];
    }
}
//연결 리스트를 이용한 스택 구현
class ListStack {
    class ListNode {
        Object data;
        ListNode link;
    }
    private ListNode top;
    public boolean isEmpty() {
        return (top==null);
    }
    public void push(Object x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = top;
        top = newNode;
    }
    public Object pop() {
        if(isEmpty()) return null;
        else {
            Object item = top.data;
            top = top.link;
            return item;
        }
    }
    public void delete() {
        if(isEmpty()) return;
        else top = top.link;

    }
    public Object peek() {
        if(isEmpty()) return null;
        else return top.data;
    }
}
//리스트
class ListNode {
    String data;
    ListNode link;
    public ListNode() {
        data =null;
        link = null;
    }
    public ListNode(String val) {
        data = val;
        link = null;
    }
    public ListNode(String val, ListNode p) {
        data = val;
        link = p;
    }
}
class LinkedList {
    private ListNode head;
    //리스트의 맨 앞에 원소 x르르 삽입
    public void addFirstNode(String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = head;
        head=newNode;
    }
    //p가 가르키는 노드 다음에 원소x 삽입
    public void insertNode(ListNode p, String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        if(head==null) {
            head = newNode;
            newNode.link = null;
        }//p가 널이면 ㅣㄹ스트의 첫번쨰노드
        else if(p ==null) {
            newNode.link = head;
            head = newNode;
        }else {
            newNode.link = p.link;
            p.link = newNode;
        }
    }
    public void addLastNode(String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = null;
        if(head==null) {
            head = newNode;
            return;
        }
        ListNode p = head;
        while(p.link !=null) {
            p = p.link;
        }
        p.link = newNode;
    }
    //리스트의 원소를 역순으로 반환
    public void reverse() {
        ListNode p = head; //역순으로 변환될 리스트
        ListNode q= null; // 역순으로 변환될 노드
        ListNode r = null;
        while(p!=null) {
            r= q;
            q = p;
            p = p.link;
            q.link = r;
        }
        head = q;
    }
    //원형 연결 리스트
    // 마지막 노드의 링크가 다시 첫번째 노드를 가르키는 리스트
    public void insertFront(ListNode p) {
        if(head ==null) {
            head = p;
            p.link = head;
        }else {
            p.link = head.link;
            head.link = p;
        }
    }
    public void insertLast(ListNode p) {
        if(head ==null) {
            head =p;
            p.link = head;
        }else {
            p.link = head.link;
            head.link = p;
            head = p;
        }
    }
}
//리스트를 이용한 다항식 덧셈
class Polynomial {
    class Term {
        int coef;
        int exp;
        Term link;
    }
    private Term head; //첫번째 항을 가르키는 레퍼런스 변수
    private Term tail; // 마지막 항을 가르키는 레퍼런스 변수
    public Polynomial() {
        head = tail = null;
    }
    public void addTerm(int coef, int exp) {
        Term term = new Term();
        term.coef = coef;
        term.exp = exp;
        term.link = null;
        if(head==null) {
            head =tail = term;
        }else {
            tail.link = term;
            tail = term;
        }
    }
    public String toString() {
        String answer = "";
        Term temp = this.head;
        if(temp ==null) {
                  answer += "0";
              }else {
                  while(temp!=null){
                      if(temp.exp==0){
                          answer+=temp.coef;
                      }else if(temp.coef==0){
                          answer+="";
                      }else if(temp.exp==1){
                          answer+="x";
                      }else if(temp.coef ==1) {
                          answer +="x^"+temp.exp;
                      }else if(temp.coef==1 && temp.exp ==1){
                          answer += "x";
                      }else {
                          answer += temp.coef +"x^" + temp.exp;
                      }
                      temp = temp.link;
                      if(temp!=null){
                          answer +="+";
                      }
                  }
              }
        return answer;
    }
    public Polynomial polyadd(Polynomial p1, Polynomial p2) {
        Term p= p1.head;
        Term q = p2.head;
        Polynomial p3 = new Polynomial();
        while(p!=null && q!=null) {
            if(p.exp ==q.exp) {
                int sum = q.coef + p.coef;
                if(sum!=0) p3.addTerm(sum,p.exp);
                q = q.link;
                p = p.link;
            }else if( q.exp > p.exp) {
                p3.addTerm(q.coef,q.exp);
                q = q.link;
            }else {
                p3.addTerm(p.coef,p.exp);
                p=p.link;
            }
        }
        while(p!=null) {
            p3.addTerm(p.coef, p.exp);
            p = p.link;
        }
        while(q!=null) {
            p3.addTerm(q.coef, q.exp);
            q = q.link;
        }
        return p3;
    }
}
//일반 리스트 표현
//리스트의 복사본 생성
class ListNode2 implements Cloneable {
    Object data;
    ListNode2 link;
    public ListNode2() {
        data = null;
        link = null;
    }
    public ListNode2(Object data) {
        this.data = data;
        link = null;
    }
    public Object clone() {
        ListNode2 newNode = new ListNode2();
        newNode.data = (data instanceof ListNode2) ? ((ListNode2)data).clone() : data;
        newNode.link = (ListNode2)link.clone();
        return newNode;
    }
}
//자바에서 일반리스트 구현
class GenList{
    private ListNode head;
    //리스트 head 다음에 새로운 ListNode를 삽입
    void insertData(Object x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = head;
        head = newNode;
    }
    void printGL() {
        System.out.print("("); 
        ListNode p = head; 
        while ( p != null ) { // 공백 리스트가 아닌 경우
            if(p.data instanceof GenList) {
                ((GenList)p.data).printGL();
            }else {
                System.out.print(p.data);
            }
            if((p = p.link)!=null) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }
}
//배열
//순차 사상 - 배열의 논리적 순서와 메모리의 물리적 순서가 같도록 표현
//순차 표현 - 순차 사상을 이용하여 데이타를 표현
//희소행렬 과 희소행렬의 전치행렬
class SparseMatrix {
    int[][]m;
    //여기서 row는 열임
    Triple[] a;
    int count,Num,Col,Row;
    public SparseMatrix(int row, int col, int no) {
        m = new int[no+1][3];
        m[0][0] = col;
        
        m[0][1] = row;
        m[0][2] = no;
        //여긴 다른 코드
        count=0;
        Num = no;
        Col = col;
        Row = row;
        a = new Triple[Num];
    }

    // 0 0 76
    // 0 4 13
    // 2 5 3
    // 3 1 25
    // 4 0 -19
    // 4 3 56
    // 5 5 13
    // 6 2 13
    public void storeTriple(int row, int col, int value) {
        if(count >=Num) {//에러
        }
        a[count++] = new Triple(row,col,value);

    }
    //row = 7 col =6 num = 8
    public SparseMatrix transpose2() {
        // row:         [0] [1] [2] [3] [4] [5]
        // rowterm:     2   1   1   1   1   2
        // rowbegins:   0   2   3   4   5   6
        int[] rowTerms = new int[Col];
        int[] rowBegins = new int[Row];
        // 6 7 8 로 들어감
        SparseMatrix b = new SparseMatrix(Col, Row, Num);
        if(Num > 0) {
            //i가 0일때 col은 0이니까 0번쨰 rowTerm을 하나 증가
            //i가 1일때 col은 4니까 4번째 rowTerm을 하나 증가
            //i가 2일때 col은 5니까 5번째 rowTerm을 하나 증가~~ 반복
            for(int i=0; i<Num; i++) {
                rowTerms[a[i].col]++;
            }
            rowBegins[0] = 0;
            //col까지 반복 이유는 begins와 rowtem이 col 개수만큼 되어 있음
            for(int i=1; i<Col; i++) {
                rowBegins[i] = rowBegins[i-1] + rowTerms[i-1];
            }
            for(int i=0; i<Num; i++) {
                int no = rowBegins[a[i].col]++;
                b.a[no] = new Triple(a[i].col,a[i].row,a[i].value);
            }
        }
        return b;
    }
    public void transpose() {
		int a= m[0][0];
		m[0][0] = m[0][1];
		m[0][1] = a;
		for(int i=1; i<=m[0][2]; i++) {
			int tempLeft,tempRight=0;
			tempLeft = m[i][0];
			tempRight = m[i][1];
			m[i][0] = tempRight;
			m[i][1] = tempLeft;
		}
		for(int i=1; i<m[0][2]; i++) {
			for(int j = i+1; j<=m[0][2]; j++){
				int[] temp = new int[1];
				if(m[j][0] < m[i][0]){
					temp = m[j];
					m[j] = m[i];
					m[i] = temp;
				}else if (m[j][0] == m[i][0]){
					if(m[j][1] < m[i][1]){
						temp = m[j];
						m[j] = m[i];
						m[i] = temp;
					}
				}
			}
		}
	}
}
//3원소 쌍의 표현
class Triple {
    int row;
    int col;
    int value;
    public Triple() {
        row = col = value =0;
    }
    public Triple(int r, int c, int v) {
        row = r;
        col = c;
        value = v;
    }
}
//알고리즘 - 특정 문제를 해결하기 위해 논리적으로 기술한 일련의 명령문
// 프로그램 = 알고리즘 + data structures  = 알고리즘을 컴퓨터가 이해하고 실행할 수 있는 특정 프로그래밍 언어로 표현한 것.
//알고리즘의 요건
// 완전성과 명확성
// 입력과 출력
// 유한성
//알고리즘의 표현
//ADL(Algorithm Descritpion Language)
//알고리즘 기술을 위해 정의한 언어
//이원탐색
class Search{
    //mid -1 +1 유의하기
    public static int binsearch(int[] a, int key, int left, int right) {
        if(left<=right) {
            int mid = (left+right)/2;
            if(key==a[mid]) return mid;
            else if(key<a[mid]) {
                return binsearch(a, key, left, mid-1);
            }else return binsearch(a, key, mid+1, right);
        }
    }
}
//프로그램 평가
//프로그램의 평가 기준
//~~
//프로그램 성능 평가
//1 성능 분석
// 성능 측정
// 공간복잡도 = 프로그램을 실행시켜 완료하는데 소요되는 총 저장 공간 = 고정공간 + 가변 공간
// 시간복잡도 = 프로그램을 실행시켜 완료하는데 걸리는 시간 = 컴파일시간 + 실행시간
//성능은 프로그램 단계 실행 빈도수로 추정
// fib_i(n)
// 1 if (n < 0)
// 2    then stop; // error 발생
// 3 if (n ≤ 1)
// 4    then return n;
// 5 fn2 ← 0;
// 6 fn1 ← 1;
// 7 for (i ← 2; i <= n; i ← i + 1) do { 
// 8 fn ← fn1 + fn2;
// 9 fn2 ← fn1;
// 10 fn1 ← fn;
// 11 }
// 12 return fn;
// 13 end fib_i()
// 명령문(행) 실행 빈도수 명령문(행) 실행 빈도수
// 명령문(행) 실행 빈도수 명령문(행) 실행 빈도수
// 1            1            8      n-1
// 2            0            9      n-1
// 3            1            10      n-1
// 4            0            11      0
// 5            1            12      1
// 6            1            13      0
// 7            n 
//7번 에서 왜 n번일까? i=1 i<=n 이여야 n번 아닌가?
// 처음에 i=2 이부분에서 초기화 할때 수행되므로 n번 인 것! 
// 연산 시간의 크기 순서
// O(1) <O(logn) < O(n) < O(nlogn) < O(n^2
// ) < O(n^3
// ) < O(2^n
// ) < O(n!) 
//따라서 bestcase는 1번 수행 될때  worst는 무한대
//1단원
//8가지 기본 타입
//정수 : int byte short long
//실수 : float , double
//문자 : char
//상수(constant) - 값이 변하지 않는 수 
//변수(variable) - 값을 저장하기 위한 기억 장소
//클래스와 객체
//class - 객체에 대한 명세(변수와 메소드 포함) -  캡슐화(encapsulation) , 정보은닉(information hiding)
//Object - 클래스의 인스턴스 - 참조변수(reference variable) - 객체를 참조하는 변수
//소프트웨어 생명주기
//소프트웨어의 중요 조건
// 효율성과 정확성
// 요구분석 -> 시스템 명세 -> 설계 -> 구현 -> 테스트 -> 유지보수
//객체지향(object-oriented design) 방법
//동적 바인딩