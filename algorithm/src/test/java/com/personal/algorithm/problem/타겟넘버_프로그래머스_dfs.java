package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 타겟넘버_프로그래머스_dfs {
    int answer = 0;
    @Test
    void test(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
    }

    void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, depth+1, target, sum + numbers[depth]);
            dfs(numbers, depth+1, target, sum - numbers[depth]);
        }
    }
}
