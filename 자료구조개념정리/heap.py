#최대값 최소값을 빠르게 찾기위한 고안된 완전 이진트리
# 노드를 삽입할 때 최하단 왼쪽노드부터 차례대로 삽입하는 트리
#힙과 이진탐색 트리의 차이점
# 힙은 각 노드의 값이 자식 노드보다 크거나 같음
# 이진 탐색 트리는 왼쪽 자식 노드의 값이 가장 작고
# 그다음 부모노드 그다음 오른쪽 노드 값이 가장 큼
class Heap:
    def __init__(self,data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
    def move_up(self,inserted_idx):
        #루트일때
        if inserted_idx <=1:
            return False
        parent_idx = inserted_idx
        if self.heap_array[inserted_idx] >self.heap_array[parent_idx]:
            return True
        else:
            return False
    def insert(self,data):
        self.heap_array.append(data) 
        inserted_idx = len(self.heap_array)-1 
        #바꿔야 된다고 판단되면(저 메소드가 True이면)
        # 부모랑 자식이랑 바꾸어 주는 것
        while self.move_up(inserted_idx):
            #부모는 자식보다 1 크니까 -1 안해주는 것
            parent_idx = inserted_idx
            #swap 해준것
            self.heap_array[inserted_idx],self.heap_array[parent_idx] = self.heap_array[parent_idx],self.heap_array[inserted_idx]
            #바꿧는데 그 부모가 더 작은경우
            #또 바꿔야 할 수도 있으니까 parent_idx로 바꿔줌
            inserted_idx = parent_idx


        return True
    