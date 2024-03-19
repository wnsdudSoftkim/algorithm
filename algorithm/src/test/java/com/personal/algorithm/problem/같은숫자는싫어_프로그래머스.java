package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/18/24
 */
public class 같은숫자는싫어_프로그래머스 {
/*
    채점 결과
        정확성: 71.9
        효율성: 28.1
        합계: 100.0 / 100.0
 */
    @Test
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (i!=0) {
                if (arr[i-1] != arr[i]) {
                    result.add(arr[i]);
                }
            } else {
                result.add(arr[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
