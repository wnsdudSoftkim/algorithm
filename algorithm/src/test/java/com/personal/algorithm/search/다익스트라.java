package com.personal.algorithm.search;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 다익스트라 {
    /*
        다익스트라(Dijkstra) 알고리즘은 방향성을 가지는 그래프에서 최단거리를 구할 때 자주 쓰인다
        코드로 구현할 때 유의하셔야 할 점이 몇 가지 있습니다. (****음의 가중치가 없어야함, 방향성 없어도 구할 수 있음 ********)
        우선 그래프를 표현할 때 보통은 2차원 배열로 선언을 많이 하는데, 2차원 배열보다는 List컬렉션을 통해서 구현하는 것을 추천드립니다.
        왜냐면 모든 노드가 간선으로 연결된 것이 아니라면 2차원 배열은 간선이 존재하지 않는 경우의 값도 저장하지만, 2차원 List로 표현을 하면 간선이 존재하는 노드들끼리의 연결만 표현할 수 있기 때문입니다.
        또한 위의 설명에서 보셨던 갱신된 노드들의 목록을 저장할 때는 우선순위 큐를 사용하셔야 합니다.

        왜냐면 처음에 갱신되었던 노드보다 나중에 갱신되었던 노드의 최단거리 값이 더 작다면 나중에 갱신되었던 노드로 방문을 진행해야 하는데 일반적은 배열에 담으면 최단거리를 기준으로 오름차순 정렬을 따로 코드로 작성해줘야 하기 때문입니다.
        우선순위 큐를 사용할 때 정렬 기준을 최단거리의 오름차순으로 미리 지정해 논다면 추후에 큐에 offer() 되는 노드들은 최단거리를 기준으로 값이 자동으로 정렬되므로 poll()로 꺼내기만 하면 다음에 방문할 노드의 인덱스를 바로 알 수 있어서 구현할 때 매우 효과적입니다.
     */

    static final int INF = 9999999;
    // 그래프를 표현 할 2차원 List
    static List<List<Node>> graph = new ArrayList<>();
    // 최단거리테이블을 표현 할 배열
    static int[] result;
    // 방문처리를 위한 배열이지만 저는 다른 방법으로 방문처리를 진행하겠습니다.
    //	static boolean[] vistied;

    public static void main(String[] args) throws IOException {
        /*
        5 6
        1
        5 1 1
        1 2 2
        1 3 3
        2 3 4
        2 4 5
        3 4 6
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int startIndex = Integer.parseInt(br.readLine());


        // 그래프 생성
        for (int i = 0; i < Integer.parseInt(info[0])+1; i++) {
            graph.add(new ArrayList<>());
        }
        // 최단거리테이블 생성
        result = new int[Integer.parseInt(info[0])+1];
        // 최단거리테이블 INF로 초기화
        Arrays.fill(result, INF);

        // 방문처리를 위한 배열 생성 (저는 사용하지 않습니다)
        // vistied = new boolean[Integer.parseInt(info[0])+1];

        // 문제에서 주어진 입력 값에 따라 그래프 초기화
        for (int i = 0; i < Integer.parseInt(info[1]); i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(new Node(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
        }

        // 문제에서 주어진 입력값을 바탕으로 다익스트라 알고리즘 수행
        dijkstra(startIndex);

    }

    // 다익스트라 알고리즘
    static void dijkstra(int index) {

        // 최단거리가 갱신 된 노드들을 담을 우선순위 큐 생성
        PriorityQueue<Node> pq =  new PriorityQueue<>();
        // 최단거리테이블의 시작지점노드 값 0으로 갱신
        result[index] = 0;
        // 우선순위 큐에 시작노드 넣기
        pq.offer(new Node(index, 0));

        // 우선순위 큐에 노드가 존재하면 계속 반복
        while(!pq.isEmpty()) {
            // 큐에서 노드 꺼내기
            Node node = pq.poll();
            // 꺼낸 노드의 인덱스 및 최단거리 비용 확인
            int nodeIndex = node.index;
            int distance = node.distance;


            // 큐에서 꺼낸 거리와 최단거리테이블의 값을 비교해서 방문처리를 합니다.
            // 큐는 최단거리를 기준으로 오름차순 정렬되고 있습니다.
            // 만약 현재 꺼낸 노드의 거리가 최단거리테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드입니다.
            // 그러므로 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냅니다.
            if(distance > result[nodeIndex]) {
                continue;
            }

            // 큐에서 꺼낸 노드에서 이동 가능 한 노드들을 탐색합니다.
            for (Node linkedNode : graph.get(nodeIndex)) {
                // 해당노드를 거쳐서 다음 노드로 이동 할 떄의 값이 다음 이동노드의 최단거리테이블 값보다 작을 때
                if(distance + linkedNode.distance < result[linkedNode.index]) {
                    // if문의 조건을 만족했다면 최단거리테이블의 값을 갱신합니다.
                    result[linkedNode.index] = distance + linkedNode.distance;
                    // 갱신 된 노드를 우선순위 큐에 넣어줍니다.
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
            }
        }
    }

    static void test(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));
        result[start] = 0;
        while(!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.distance > result[currentNode.index]) {
                continue;
            }
            for (Node nextNode: graph.get(currentNode.index)) {
                if (currentNode.distance + nextNode.distance < result[nextNode.index]) {
                    result[nextNode.index] = currentNode.distance + nextNode.distance;
                    priorityQueue.offer(new Node(nextNode.index, result[nextNode.index]));
                }
            }
        }

    }


    static void dijkstra2(int start) {
        PriorityQueue<Node> q =  new PriorityQueue<>();
        int[] dist = new int[1000 + 1]; // 최소 비용을 저장할 배열

        // 초기화
        q.offer(new Node(start, 0));
        // 해당 노드를 선택한 것이나 마찬가지 이므로, dist[start] = 0으로 갱신.
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node curNode = q.poll();

            // 목표 정점이 꺼내 졌다면, 해당 노드까지는 최솟값 갱신이 완료 되었다는 것이 확정이다(다익스트라 알고리즘).
            // 따라서, 반복문을 종료해도 되지만, 해당 코드는 시작 정점에 대하여 모든 정점으로의 최단 경로를 구하는 것을 가정한다.
            // 아래 주석된 코드는 목표 정점이 구해졌다면 빠르게 탈출할 수 있는 조건이다.
//			if (curNode.idx == end) {
//				System.out.println(dist[curNode.idx]);
//				return;
//			}

            // 꺼낸 노드 = 현재 최소 비용을 갖는 노드.
            // 즉, 해당 노드의 비용이 현재 dist배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵한다.
            // 주의점 2 : 중복노드 방지1 : 만일, 이 코드를 생략한다면, 언급한 내용대로 이미 방문한 정점을 '중복하여 방문'하게 된다.
            // 만일 그렇다면, 큐에 있는 모든 다음 노드에대하여 인접노드에 대한 탐색을 다시 진행하게 된다.
            // 그래프 입력이 만일 완전 그래프의 형태로 주어진다면, 이 조건을 생략한 것 만으로 시간 복잡도가 E^2에 수렴할 가능성이 생긴다.
            if (dist[curNode.index] < curNode.distance) {
                continue;
            }

            // 선택된 노드의 모든 주변 노드를 고려한다.
            for (int i = 0; i < graph.get(curNode.index).size(); i++) {
                Node nxtNode = graph.get(curNode.index).get(i);
                // 만일, 주변 노드까지의 현재 dist값(비용)과 현재 선택된 노드로부터 주변 노드로 가는 비용을 비교하고, 더 작은 값을 선택한다.
                // 주의점 3 : 중복노드 방지 2 : 만일, 조건문 없이 조건문의 내용을 수행한다면 역시 중복 노드가 발생한다.
                // 간선에 연결된 노드를 모두 넣어준다면 앞서 언급한 정점의 시간 복잡도 VlogV를 보장할 수 없다.
                // 마찬가지로 E^2에 수렴할 가능성이 생긴다. 따라서 이 조건 안에서 로직을 진행해야만 한다.
                if (dist[nxtNode.index] > curNode.distance + nxtNode.distance) {
                    dist[nxtNode.index] = curNode.distance + nxtNode.distance;
                    // 갱신된 경우에만 큐에 넣는다.
                    q.offer(new Node(nxtNode.index, dist[nxtNode.index]));
                }
            }
        }

        // 결과 출력
        System.out.println(Arrays.toString(dist));
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

}
