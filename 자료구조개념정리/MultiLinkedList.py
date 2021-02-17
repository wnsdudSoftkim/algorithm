# 다양한 링크드 리스트 구조
# 더블 링크드 리스트의 기본구조
#이전데이터주소|데이터|다음데이터주소 <-> 이전데이터주소|데이터|다음데이터주소
class Node:
    def __init__(self,data,prev=None,next=None):
        self.prev = prev
        self.data = data
        self.next = next
# 코드를 보면 앞에도 헤드가 있고 뒤에도 tail 이라는 헤드가 있음!!
class NodeMgt:
    def __init__(self,data):
        self.head = Node(data)
        self.tail = self.head
    def insert(self,data):
        if self.head = None:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = self.head
            while node.next:
                #노드의 끝을 찾아간다
                node = node.next
            #None 값이 들어있는 마지막 node.next를(원래는 tail이엿음)
            # tail과 연결시켜주는 작업(우리가 넣은 데이터가 tail이 됨)
            #Node(data)가 tail인 것
            node.next = Node(data)
            #tail의 prev를 앞에있는거랑 연결
            Node(data).prev = node
            self.tail = Node(data)
    def print(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
    # 노드 데이터를 특정 숫자 앞에 데이터를 추가하는 함수를 짜보자!
    def insert_before(self,data,before_data):
        node = self.tail
        new = Node(data)
        before_new = node.prev
        before_new.next = new
        new.next = node
        node.prev = new
        