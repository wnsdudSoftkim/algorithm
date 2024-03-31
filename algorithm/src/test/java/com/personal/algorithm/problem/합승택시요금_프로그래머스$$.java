package com.personal.algorithm.problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 합승택시요금_프로그래머스$$ {
    static int N;
    static final int INF = 9999999;
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        for (int i=0; i<= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] fare: fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];
        Arrays.fill(startA, INF);
        Arrays.fill(startB, INF);
        Arrays.fill(start, INF);
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        int answer = 9999999;
        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        return answer;

    }
    public int[] dijkstra(int start, int[] result) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));
        result[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.distance > result[currentNode.index]) {
                continue;
            }
            for (Node nextNode: graph.get(currentNode.index)) {
                if(currentNode.distance + nextNode.distance < result[nextNode.index]) {
                    result[nextNode.index] = currentNode.distance + nextNode.distance;
                    priorityQueue.offer(new Node(nextNode.index, result[nextNode.index]));
                }
            }
        }
        return result;
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
            return Integer.compare(o.distance, this.distance);
        }
    }
}
