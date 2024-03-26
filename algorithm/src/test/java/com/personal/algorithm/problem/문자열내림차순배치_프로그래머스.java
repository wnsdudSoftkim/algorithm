package com.personal.algorithm.problem;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 문자열내림차순배치_프로그래머스 {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());

        for(String a : str)
            answer += a;

        return answer;
    }
}
