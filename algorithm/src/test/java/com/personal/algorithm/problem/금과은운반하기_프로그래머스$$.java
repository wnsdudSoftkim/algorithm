package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 금과은운반하기_프로그래머스$$ {
    @Test
    public long solution() {
        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};
        int cityCount = g.length;
        int[] result = new int[cityCount];
        PriorityQueue<Node> goldCapacity = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Node> silverCapacity = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i< cityCount; i ++) {
            int currentWeight = w[i];
            int currentTime = t[i];
            int currentGoldAvilable = g[i];
            int currentSilverAvilable = s[i];
            if (currentGoldAvilable > 0) {
                goldCapacity.offer(new Node(i, (currentGoldAvilable-currentWeight)/currentTime));
            }
            if (currentSilverAvilable >0) {
                silverCapacity.offer(new Node(i, (currentSilverAvilable-currentWeight)/currentTime));
            }
        }
        int goldDoneTime = 0;
        int silverDoneTime = 0;
        for (int i=0; i< cityCount; i++) {
            Node goldCpa = goldCapacity.poll();
            while (g[goldCpa.index] >0) {
                int weight = w[goldCpa.index];
                g[goldCpa.index] -= weight;
                while (a > 0) {
                    a -= weight;
                }
                if (g[goldCpa.index] >0) goldDoneTime += (2*t[goldCpa.index]);
                else goldDoneTime += t[goldCpa.index];
            }
        }
        System.out.println(goldDoneTime);
        return 0;
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
