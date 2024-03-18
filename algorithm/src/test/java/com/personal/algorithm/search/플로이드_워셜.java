package com.personal.algorithm.search;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 플로이드_워셜 {
    /*
        플로이드-워셜 알고리즘은 음수 사이클이 없는 그래프내의 각 모든 정점에서 각 모든 정점에 까지의 최단거리를 모두 구할 수 있는 알고리즘이다. 다익스트라 알고리즘과는 다르게 그래프에 음수 사이클만 존재하지 않으면,
        음의 가중치를 갖는 간선이 존재해도 상관이 없다는 것이다.
        ※ 음수 사이클 : 사이클의 모든 경로를 지나 원래 지점으로 돌아 왔을때, 최종적인 비용이 음수가 되는 경우.
         플로이드-워셜 알고리즘은 다이나믹 프로그래밍 기법을 사용한 알고리즘이고, 인접 행렬을 이용하여 각 노드간 최소 비용을 계산한다.

        구현을 확인하면 알 수 있겠지만, 시간 복잡도를 구하는 방법은 매우 간단한다. 모든 노드(V)에 대해서, V x V 행렬을 갱신해주는 연산을 진행하므로 O(V^3)의 시간복잡도를 갖는다.
        무려 O(V^3)라는 시간 복잡도를 갖기 때문에, 입력의 크기가 100 정도만 되어도 백 만번의 연산이 수행되어야 한다. 따라서, 플로이드 알고리즘을 사용하는 경우는 입력의 크기를 주의깊게 살펴보도록 하자.
     */
    @Test
    void test(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] result = new int[N][M];
        // 초기화
        for (int i=0; i< N; i++) {
            for (int j =0; j<N; j++) {
                if (i==j) {
                    result[i][j] =0;
                }
                // 자기 자신으로 가는 경우를 제외하고는 매우 큰 값(N개의 노드를 모두 거쳐서 가더라도 더 큰 값).
                result[i][j] = 100_000_000;
            }
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            // 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
            result[a][b] = Math.min(result[a][b], distance);
            result[b][a] = Math.min(result[b][a], distance);
        }


    }

    void floydWarshall(int nodeCount, int[][] result) {
        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
        for (int i=0; i<nodeCount; i++) {
            // 노드 i에서 j로 가는 경우.
            for (int j = 0; j< nodeCount; j++) {
                for (int k=0; k<nodeCount; k++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }
    }
}
