package com.personal.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/27/24
 */
public class 정수삼각형_프로그래머스$$ {
    /*
        DP문제
     */
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >=0 ; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return triangle[0][0];
    }
}
