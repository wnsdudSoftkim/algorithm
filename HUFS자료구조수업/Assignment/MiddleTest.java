package Assignment;



public class MiddleTest {
    public static void main(String[] args) {
        System.out.println("john".compareTo("tom"));
    }
}
//일반 큐 로직
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
        q[rear] = item;
        rear +=1;
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
        itemArray[rear] = x;
        rear = (rear+1) % queueSize;
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
    //front는 왜 0으로 가는거지?
    public void queueFull() {
        int oldSize = queueSize;
        queueSize+=increment;
        Object[] tempArray = new Object[queueSize];
        for(int i=0; i<count; i++) {
            //임시 배열로 원소들을 그대로 이동
            tempArray[i] = itemArray[front];
            front = (front+1)%oldSize;
        }
        itemArray = tempArray; //배열 이름을 변경
        front = 0;
        rear = count;
    }
}
//큐를 연결리스트로 표현
class ListNode {
    Object data;
    ListNode link;
}
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