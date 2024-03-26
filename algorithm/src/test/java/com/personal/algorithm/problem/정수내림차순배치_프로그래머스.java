package com.personal.algorithm.problem;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 정수내림차순배치_프로그래머스 {
    public long solution(long n) {
        String st = String.valueOf(n);
        Integer[] intA = new Integer[st.length()];
        int index = 0;
        for (char s: st.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(s));
            intA[index] = i;
            index ++;
        }
        Arrays.sort(intA, Collections.reverseOrder());
        String result = "";
        for (int a : intA) {
            result += String.valueOf(a);
        }
        return Long.parseLong(result);
    }

    //다른사람 풀이
    public long solution2(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }

}
