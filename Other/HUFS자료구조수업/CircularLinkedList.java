package Other.HUFS자료구조수업;
class ListNode{
    private ListNode link;
}
public class CircularLinkedList {
    //자유공간 리스트
    //원형연결 리스트
    private ListNode head;
    private int length;
    public CircularLinkedList() {
        head = null;
        length=0;
    }
    public void insertFront(ListNode p) {
        if(head ==null) {
            head = p;
            p.link = head;
        }else {
            p.link = head.link;
            head.link = p;
        }
        length++;
    }


}

