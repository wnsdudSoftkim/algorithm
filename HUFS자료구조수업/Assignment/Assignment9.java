package HUFS자료구조수업.Assignment;
import java.util.*;

class Graph {
    int vertex;
    ListNode[] array;
    boolean[] visited;
    class ListNode {
        int data;
        ListNode link;
        public ListNode() {}
        public ListNode(int data) {
            this.data = data;
        }
    }
    public Graph(int vertex) {
        this.vertex = vertex;
        array = new ListNode[vertex];
        for(int i=0; i<vertex; i++) {
            array[i] = new ListNode();
            array[i].data = i;
        }
        visited = new boolean[vertex];
    }
    public void addEdge(int i, int j) {
    }

}
public class Assignment9 {
}
