#최단경로 알고리즘의 이해
#다익스트라 알고리즘 파이썬 구현(우선순위 큐 활용까지 포함)
# heapq 라이브러리 활용을 통해 우선순위 큐 사용하기
import heapq
queue = []
#key value라고 생각
heapq.heappush(queue,[2,'A'])
heapq.heappush(queue,[5,'B'])
heapq.heappush(queue,[1,'C'])
heapq.heappush(queue,[7,'D'])
#print(queue)
#[[1,'C'],[5,'B'],[2,'A'],[7,'D']]
# 첫번째는 당연히 1인 C이고 그 이후로는 완벽하게 sort 된건 아님 왜냐면 부모가 자식보다 크기만 하면 되니까
for index in range(len(queue)):
    print(heapq.heappop(queue))
#[1,'C']
#[2,'A']
#[5,'B']
#[7,'D']
#A에서 F로 가는데 그림이 주어지고 숫자는 가는 시간이다. 최단거리 -> 이런식으로 그래프를 만든다
#빈 것은 갈 수 있는 루트가 없는 것
mygraph = {
    'A':{'B':8,'C':1,'D':2},
    'B':{},
    'C':{'B':5,'D':2},
    'D':{'E':3,'F':5},
    'E':{'F':2},
    'F':{}
}
import heapq
#float('inf')는 무한대 값을 표현해 준 것이다.
def dijkstra(graph,start):
    #graph에 있는 노드 6개가 node로 들어가는데 key:value 형태로 만들어주기 위해 아래 형태를 썼음
    distance = {node:float('inf') for node in graph}
    #A B    C   D   E   F
    #0 inf  inf inf inf inf 
    distance[start]=0
    queue=[]
    heapq.heappush(queue,[distance[start],start])
    #우선순위 큐
    #A
    #0
    #이부분 중요
    while queue:

        #데이터 꺼내는 작업
        #위를 보면
        #distance[start] 가 current_distance로 들어가고
        #start 가 current_node로 들어간다
        current_distance,current_node = heapq.heappop(queue)
        #만약 기존에 있던 경로가 더 작으면 이 조건문 아래 코드를 실행할 필요가 없어짐.
        if distances[current_node] < current_distance:
            continue

        for adjacent,weight in graph[current_node].items():
            distance = current_distance+weight
            #현재 경로가 기존에 있던 최단거리보다 큰지 작은지 보는 것
            #현재 경로가 더 작다면
            if distance < distances[adjacent]:
                distance[adjacent] = distance
                heapq.heappush(queue,[distance,adjacent])
        return distances
                
