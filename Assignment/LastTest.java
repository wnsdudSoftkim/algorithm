
public class LastTest {
    public static void main(String[] args) {
        return;
    }
}
class Queue {
    private Object[] q;
    private int front,rear;
    private int n=10;
    public Queue() {
        q = new Object[n];
        front = rear = -1;
    }
    public boolean isEmpty() {
        return (front==rear);
    }
    public void enqueue(String x) throws Exception{
        if(rear==n-1) throw new Exception();
        q[++rear] = x;
    }
    public Object dequeue() {
        if(isEmpty()) return null;
        return q[++front];

    }
    public void delete() throws Exception{
        if(isEmpty()) throw new Exception();
        front++;
    }
}
//여기서 enqueue할때 1번 인덱스 부터 시작하는 이유는
//원형큐나 배열 큐는 첫번째 처음 enqueue할떄는 비워둔다.( 0부터 시작)
//배열 큐는 count, queueSizeFull 가 추가된다
class CircularQueue {
    private Object[] q;
    private int front, rear;
    private int queueSize = 50;
    public CircularQueue() {
        q = new Object[queueSize];
        front = rear=  0;
    }
    public boolean isEmpty() {
        return (front==rear);
    }
    public void enqueue(String x) {
        rear = (rear+1)%queueSize;
        q[rear] = x;
    }
    public Object dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        Object item = q[front];
        front = (front+1)%queueSize;
        return item;
    }
}
class ArrayQueue {
    private Object q[];
    private int front,rear;
    private int queueSize = 50;
    private int increment = 10;
    private int count=0;
    public ArrayQueue() {
        q= new Object[queueSize];
        front = rear=  0;
    }
    public boolean isEmpty() {
        return (front==rear);
    }
    public void enqueue(String x) {
        if(count==queueSize) queueSizeFull();
        rear = (rear+1)%queueSize;
        q[rear] = x;
        count++;
    }
    public Object dequeue() throws Exception{
        if(isEmpty()) throw new Exception();
        Object item = q[front];
        front = (front+1)%queueSize;
        return item;
    }
    public void queueSizeFull() {
        int oldSize = queueSize;
        queueSize += increment;
        for(int i=0; i<oldSize; i++) {
            q[i] = q[front];
            front = (front+1)%oldSize;
            count++;
        }
        front = 0;
        rear = count;
    }
}
class ListNode {
    Object data;
    ListNode link;
}
class ListQueue {
    private ListNode front;
    private ListNode rear;
    private int count;
    public ListQueue() {
        front = rear = null;
        count=0;
    }
    public void enqueue(String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = null;
        if(count==0) {
            front=rear=newNode;
        }else {
            rear.link = newNode;
            rear = newNode;
        }
        count++;
    }
    public Object dequeue() {
        if(count==0) return null;
        Object item = front.data;
        front = front.link;
        //삭제 후 공백이 된 경우
        if(front==null) rear =null;
        count--;
        return item;
    }
}
//큐는 front rear ,스택은 top
//스택은 First in Last Out
class ArrayStack {
    private Object[] stack;
    private int top;
    private int stackSize=50;
    private int increment=10;
    public ArrayStack() {
        stack = new Object[stackSize];
        top = -1;
    }
    public boolean isEmpty() {
        return (top ==-1);
    }
    public void push(String x) {
        if(top==stackSize-1) stackSizeFull();
        stack[++top] = x;
    }
    public Object pop() {
        if(isEmpty()) return null;
        else return stack[top--];
    }
    public void stackSizeFull() {
        stackSize += increment;
        Object[] tempArray = new Object[stackSize];
        for(int i=0; i<stackSize; i++) {
            tempArray[i] = stack[i];
        }
        stack = tempArray;
    }
}
//연결 리스트 스택
class ListStack {
    private ListNode top;
    public boolean isEmpty() {
        return (top==null);
    }
    public void push(String x) {
        ListNode newNode=  new ListNode();
        newNode.data =x;
        newNode.link = top;
        top = newNode;
    }
    public Object pop() {
        if(isEmpty()) return null;
        Object item = top.data;
        top = top.link;
        return item;


    }

}
//단순 연결 리스트 - head가 있슴
class LinkedList {
    private ListNode head;
    public void addFirstNode(String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = null;
        newNode.link = head.link;
        head = newNode;
    }
    //p가 가르키는 노드 다음에 삽입
    public void insertNode(ListNode p, String x) {
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = null;
        if(head==null) {
            head = newNode;
            newNode.link = null;
        }else if(p==null) {
            newNode.link = head;
            head =newNode;

        }else {
            newNode.link =p.link;
            p.link = newNode;
        }

    }
}

