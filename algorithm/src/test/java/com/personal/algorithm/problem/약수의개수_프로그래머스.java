package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/18/24
 */
public class 약수의개수_프로그래머스 {
/*
채점 결과
    정확성: 85.7
    합계: 85.7 / 100.0
 */
    @Test
    public int solution(int left, int right) {
        Map<Integer, Integer> answerMap = new HashMap<>();
        for (int i=left; i<=right; i++) {
            answerMap.put(i, 2);
            for (int j = (int) Math.sqrt(i); j>1; j--) {
                if (i%j==0) {
                    if (j*j == i) {
                        answerMap.merge(i, 1, Integer::sum);
                    }else {
                        answerMap.merge(i, 2, Integer::sum);
                    }

                }
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: answerMap.entrySet()) {
            if(entry.getValue() % 2 == 0) sum += entry.getKey();
            else sum -= entry.getKey();
        }
        return sum;
    }

    @Test
    public int solution2(int left, int right) {
        Map<Integer, Integer> answerMap = new HashMap<>();
        for (int i=left; i<=right; i++) {
            if (i == 1) {
                answerMap.put(i, 1);
            }else {
                answerMap.put(i, 2);
            }

            for (int j = (int) Math.sqrt(i); j>1; j--) {
                if (i%j==0) {
                    if (j*j == i) {
                        answerMap.merge(i, 1, Integer::sum);
                    }else {
                        answerMap.merge(i, 2, Integer::sum);
                    }

                }
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: answerMap.entrySet()) {
            if(entry.getValue() % 2 == 0) sum += entry.getKey();
            else sum -= entry.getKey();
        }
        return sum;
    }
}
