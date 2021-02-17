## 큐 구조
# 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조 FIFO LILO
# 스택과 꺼내는 순서가 반대
# enqueue dequeue
import queue
#queue 라이브러리 안에 Queue 클래스
data_queue = queue.Queue()
data_queue.put("d")
data_queue.qsize() # 1
data_queue.get() # d 출력되면서 큐에서 데이터가 빠져나감 qsize 0이 됨

#LifoQueue로 큐 만들기 Last in First Out
data_queue2 = queue.LifoQueue()
data_queue2.put("d")
data_queue2.get() #마지막에 넣은 게 먼저 출력 
#PriorityQueue 로 만들기
data_queue3 = queue.PriorityQueue()
data_queue3.put((10,"d")) # 튜플형식으로 들어감 우선순위 : '데이터'
#나갈떄도 우선순위에 맞게 나간다.
# 어디에 큐가 많이 쓰일까?
#멀티 태스킹을 위한 프로세스 스케쥴링 방식을 구현하기 위해 많이 사용됨
#리스트 변수로 큐를 다루는 enqueue , dequeue 기능 구현해보기
queue_list = list()
def enqueue(data):
    queue_list.append(data)
def dequeue():
    data = queue_list[0]
    del queue_list[0]
    return data