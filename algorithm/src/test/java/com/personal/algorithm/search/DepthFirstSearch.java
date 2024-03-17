package com.personal.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class DepthFirstSearch {
    /*
        그래프와 트리를 탐색할 때 사용되는 DFS알고리즘
     */
    @Test
    void search() {
        boolean[] vistied = new boolean[9];
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
        dfs(1, graph, vistied);
    }
    static void dfs(int nodeIndex, int[][] graph, boolean[] visited) {
//        // 방문 처리
//        visited[nodeIndex] = true;
//
//        // 방문 노드 출력
//        System.out.print(nodeIndex + " -> ");
//
//        // 방문한 노드에 인접한 노드 찾기
//        for (int node : graph[nodeIndex]) {
//            // 인접한 노드가 방문한 적이 없다면 DFS 수행
//            if(!visited[node]) {
//                dfs(node, graph, visited);
//            }
//        }
        visited[nodeIndex] = true;
        for (int node: graph[nodeIndex]) {
            if(!visited[node]) {
                dfs(node, graph, visited);
            }
        }
    }
}
