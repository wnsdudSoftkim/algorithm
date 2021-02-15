#documentDB라고 생각
#면접볼때 많이 물어보는 것 중 하나
#이진 트리와 이진탐색 트리
# 이진트리는 최대 branch가 2인 트리
# 이진탐색트리는 이진트리에 추가적인 조건
# 왼쪽은 해당 노드보다 작은값 오른쪽은 해당 노
#드 보다 큰값이어야 한다
#노드 클래스 만들기
class Node:
    def __init__(self,value):
        self.value = value
        self.left = None
        self.right=None
class NodeMgmt:
    def __init__(self,head):
        self.head = head
    def insert(self,value):
        self.current_node = self.head
        while True:
            #왼
            if value < self.current_node.value:
                if self.current_node.left !=None:
                    self.current_node = self.current_node.left
                else:
                    self.current_node.left = Node(value)
                    break
            #오
            else:
                if self.current_node.right!=None:
                    self.current_node = self.current_node.right
                else:
                    self.current_node.right =Node(value)
                    break
    def search(self,value):
        self.current_node = self.head
        #None이 되면 while문 종료
        while self.current_node:
            if self.current_node.value==value:
                return True
            elif value< self.current_node.value:
                self.current_node = self.current_node.left
            else:
                self.current_node = self.current_node.right
        #while문에서 return 값을 반환한게 없을때
        return False 
    def delete(self,value):
        searched = False
        self.current_node = self.head
        self.parent = self.head
        while self.current_node:
            if self.current_node.value==value:
                searched=True
                break
            elif value<self.current_node.value:
                self.parent = self.current_node
                self.current_node = self.current_node.left
            else:
                self.parent = self.current_node
                self.current_node = self.current_node.right
        #여기로 코드가 넘어오는 경우는 2가지경우
        # while문이 정상적으로되서 searched가 True가 된경우
        # 혹은 while문이 정상 작동 되지 않은경우
        if searched == False:
            return False
        
head = Node(1)
BST = NodeMgmt(head)
BST.insert(2)
#이진 탐색 트리 삭제
# 매우 복잡함, 경우를 나누어서 이해하는 것이 좋음 
# 1. 맨 끝 노드
# 2. 자식 노드가 1개일떄
# 3. 자식 노드가 2개 일때
#1

            