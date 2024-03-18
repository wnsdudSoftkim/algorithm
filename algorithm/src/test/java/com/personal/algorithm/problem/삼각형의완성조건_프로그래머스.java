package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/18/24
 */
public class 삼각형의완성조건_프로그래머스 {

    @Test
    public int solution(int[] sides) {
        int min = Math.min(sides[0], sides[1]);
        return 2 * min -1;
    }
}
