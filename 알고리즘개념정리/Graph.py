#그래프란?
# 실제 세계의 현상이나 사물을 정점(Vertex) 또는 노드와 간선으로 
# 표현하기 위해 사용 
#집 -> 지하철 -> 회사 -> 버스 -> 집
#그래프의 종류
#1. 무방향 그래프 (간선을 통해 양방향으로 갈 수 있음)
#2. 방향 그래프(A->B이면 <A,B>라고 표현)
#3. 가중치 그래프 또는 네트워크(간선에 비용 또는 가중치가 할당)
#4. 연결그래프와 비연결그래프
#(둘다 무 방향 그래프임)
# 사이클 = 시작과 끝이 같은것
#6. 완전그래프 - 모든 노드가 서로 연결되어 있는 그래프
#너비 우선 그래프 (BFS)
#BFS란 정점들과 같은 레벨 에 있는 노드들을 먼저 탐색
#깊이 우선 탐색 (DFS)
#DFS란 정점의 자식들을 먼저 탐색
graph = dict()
graph['A'] = ['B','C']
graph['B'] = ['A','D']
graph['C'] = ['A','G','H','I']
graph['D']= ['B','E','F']
graph['E']= ['D']
graph['F']= ['D']
graph['G']= ['C']
graph['H']= ['C']
graph['I'] = ['C','J']
graph['J']= ['I']
#리스트 append와 extend의 차이점은
#append는 그차에를 원소로 넣고
#extend는 iterable의 각 항목을 원소로 넣습니다.
def bfs(graph,start_node):
    visited = list()
    need_visit = list()
    need_visit.append(start_node)
    while need_visit:
        node = need_visit.pop(0)
        if node not in visited:
            visited.append(node)
            need_visit.extend(graph[node])
    return visited
bfs(graph,'A')
def dfs(graph,start_node):
    visited,need_visited =list(),list()
    while need_visited:
        #인자를 안집어 넣으면 끝에있는 것이 pop 되는 것
        node = need_visited.pop()
        visited.append(node)
        need_visited.extend(graph[node])
    return visited