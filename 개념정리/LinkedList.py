# 연결 리스트 라고도 함
#화살표로 연결해서  관리하는 데이터 구조
# 노드(데이터값,포인터)로 구성
#데이터 | 다음데이터주소
class Node:
    def __init__(self,data,next=None):
        self.data=data
        self.next=next
node1 = Node(1)
node2 = Node(2)
node1.next=node2
head=node1
#데이터 추가
def add(data):
    #처음 시작 
    node=head
    #노드의 끝을 찾음
    while node.next:
        node=node.next
    node.next = Node(data)
#데이터 출력
def printnode():
    node=head
    while node.next:
        print(node.data)
        node=node.next
def search(data):
    node=head
    Search=True
    while Search:
        if node.data ==1:
            Search=False
        else:
            node = node.next
#특정 노드 삭제(중간에 있는 노드 삭제)
def delete(data):
    node= head
    while node.next:
        if node.next.data==data:
            temp = node.next
            node.next = node.next.next
            del temp

