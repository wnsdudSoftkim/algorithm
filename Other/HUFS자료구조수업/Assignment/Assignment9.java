package Other.HUFS자료구조수업.Assignment;

import java.util.Scanner;

// 필요한 메소드를 추가하여 아래 클래스를 완성하시오.
class Graph {

    // 필요한 field, method는 추가하시오.
    private ListNode []header;
    private ListNode tail;

    class ListNode {
        int data = 0;
        ListNode link = null;
        //ListNode head;
    }
    class Stack {
        private ListNode top;

        public Stack(){
            top = null;
        }
        public void push(int i){
            ListNode NewNode = new ListNode();
            NewNode.data = i;
            NewNode.link = top;
            top = NewNode;
        }
        public int pop(){
            if(isEmpty())
                return -1;
            else{
                int item = top.data;
                top = top.link;
                return item;
            }
        }
        public boolean isEmpty(){
            return(top == null);
        }
    }//end of Stack class

    class Queue{
        private ListNode f;
        private ListNode r;
        private int count;

        public Queue(){
            f = null;
            r = null;
            count = 0;
        }
        public boolean isEmpty(){
            return (count == 0);
        }
        public void enqueue(int x){
            ListNode NewNode = new ListNode();
            NewNode.data = x;
            NewNode.link = null;
            if(isEmpty())
                f = r = NewNode;
            else {
                r.link = NewNode;
                r = NewNode;
            }
            count++;
        }
        public int dequeue(){
            if(isEmpty())
                return -1;
            int item = f.data;
            f = f.link;
            if(f == null)
                r = null;
            count--;
            return item;
        }

    }//end of Queue class

    // 생성자를 작성하시오.
    public Graph(int noVertex) {
        int n = noVertex;
        header = new ListNode[n];
        for(int t = 0; t < n; t++)
            header[t] = null;
    }

    // 간선 (i, j)를 삽입한다.
    public void addEdge(int i, int j) {
        ListNode NewNode = new ListNode();
        if(header[i] == null){ // 처음삽입o
            NewNode.data = j;
            tail = NewNode;
            header[i] = NewNode;
        }
        else { // 처음삽입x
            NewNode.data = j;
            tail.link = NewNode;
            tail = NewNode;
        }

    }

    // 간선 (i, j)를 삭제한다.
    public void removeEdge(int i, int j) {
        if(header[i] == null)
            return ;
        else if(header[i].data == j){
            header[i] = header[i].link;
        }
        else {
            for(ListNode d = header[i]; d != null; d = d.link){
                if(d.link.data == j)
                    d.link = d.link.link;
            }
        }
    }

    // BFS로 탐색하면서 방문하는 노드를 출력한다.
    // vertex에서 시작한다.
    public void bfs(int vertex) {
        int w = 0;
        int count_bfs = 0;
        boolean [] visited = new boolean[header.length];

        for(int i=0; i<header.length; i++)
            visited[i] = false;
        Queue queue = new Queue();
        queue.enqueue(vertex);

        while(!queue.isEmpty()){
            w = queue.dequeue();
            if(visited[w] == false){
                count_bfs++;
                if(count_bfs == header.length)
                    System.out.print(w);
                else
                    System.out.print(w + " "); // visit j
                visited[w] = true; // 방문한 것으로 마크

                for(ListNode q = header[w]; q != null; q = q.link){ // 정점 j에 인접한 정점 중에서
                    if(visited[q.data] == false) //아직방문하지 않은 정점 k
                        queue.enqueue(q.data);
                }
            }
        }//end of while
    }//end of dfs

    // DFS로 탐색하면서 방문하는 노드를 출력한다.
    // vertex에서 시작한다.
    public void dfs(int vertex) {
        int j = 0;
        int count_dfs = 0;
        boolean [] visited = new boolean[header.length];
        for(int i=0; i<header.length; i++)
            visited[i] = false;
        Stack stack = new Stack();
        stack.push(vertex);
        while(!stack.isEmpty()){
            j = stack.pop();
            if(visited[j] == false){
                count_dfs++;
                if(count_dfs == header.length)
                    System.out.print(j);
                else
                    System.out.print(j + " "); // visit j
                visited[j] = true; // 방문한 것으로 마크

                for(ListNode p = header[j]; p != null; p = p.link){ // 정점 j에 인접한 정점 중에서
                    if(visited[p.data] == false) {//아직방문하지 않은 정점 k
                        stack.push(p.data);
                    }
                }
            }
        }//end of while
    }//end of dfs

    // 그래프를 출력하는 메소드이다.
    public void print() {
        for(int k=0; k<header.length; k++){
            System.out.print(k + " ");
            for(ListNode p = header[k]; p != null; p = p.link){
                if(p.link == null)
                    System.out.print(p.data);
                else
                    System.out.print(p.data + " ");
            }
            if(k < header.length-1)
                System.out.println();
        }
    }
}

class Main {

    // main 메소드는 수정하지 마시오.
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int noVertex = scan.nextInt();
        Graph graph = new Graph(noVertex);

        for(int i = 0; i < noVertex; i++) {
            for(int j = 0; j < noVertex; j++) {
                int vertex = scan.nextInt();
                if (vertex == 1)
                    graph.addEdge(i, j);
            }
        }


        while(scan.hasNext()) {
            String cmd = scan.next();
            if (cmd.equals("P"))
                graph.print();
            else if (cmd.equals("I")) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                graph.addEdge(from, to);
            } else if (cmd.equals("D")) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                graph.removeEdge(from, to);
            } else if (cmd.equals("DFS")) {
                int vertex = scan.nextInt();
                graph.dfs(vertex);
            } else if (cmd.equals("BFS")) {
                int vertex = scan.nextInt();
                graph.bfs(vertex);
            } else if (cmd.equals("E")) { // 종료한다.
                break;
            }
        }

        scan.close();
    }
}