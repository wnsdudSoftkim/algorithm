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
        코드로 구현할 때 유의하셔야 할 점이 몇 가지 있습니다.
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
