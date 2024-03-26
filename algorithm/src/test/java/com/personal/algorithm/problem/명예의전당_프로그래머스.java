package com.personal.algorithm.problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 명예의전당_프로그래머스 {
    /*
    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
     */
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> glory = new PriorityQueue<>();
        int[] result = new int[score.length];
        int index =0;
        for (int sc: score) {
            if (index >= k) {
                int pool = glory.poll();
                if (pool < sc) {
                    glory.add(sc);
                    result[index] = glory.peek();
                } else {
                    glory.add(pool);
                    result[index] = pool;
                }
            } else {
                glory.add(sc);
                result[index] = glory.peek();
            }
            index ++;
        }
        return result;
    }
}
