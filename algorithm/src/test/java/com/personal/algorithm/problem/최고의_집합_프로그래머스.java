package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 최고의_집합_프로그래머스 {


    /*
    채점 결과
        정확성: 70.0
        효율성: 5.0
        합계: 75.0 / 100.0
     */
    @Test
    public int[] solution(int n, int s) {
        // int[] answer = {};
        // return answer;
        int dividedNumber = s / n;
        if (dividedNumber < 0) {
            return new int[]{-1};
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< n; i ++) {
            result.add(dividedNumber);
        }
        result.sort(Comparator.naturalOrder());
        int sum = result.stream().mapToInt(Integer::intValue).sum();
        int rest = s - sum;
        int cursor = n-1;
        while (rest > 0) {
            result.set(cursor, result.get(cursor)+1);
            cursor--;
            rest--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public int[] solution2(int n, int s) {
        if(n > s)
            return new int[]{-1};

        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++)
            answer[i] = s/n;

        for(int i=0; i<s%n; i++)
            answer[i] ++;

        Arrays.sort(answer);

        return answer;
    }
}
