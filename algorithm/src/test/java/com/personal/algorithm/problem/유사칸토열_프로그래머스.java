package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 유사칸토열_프로그래머스 {

    /*
    채점 결과
        정확성: 60.0
        합계: 60.0 / 100.0

     */
    @Test
    public int solution() {
        int n = 2;
        int l = 4;
        int r = 17;
//        1, 11011
        List<String> numberList = List.of("1");
        int now = 0;
        while(now < n) {
            List<String> temp = new ArrayList<>();
            for(String a: numberList) {
                if (a.equals("1")) {
                    temp.addAll(List.of("1","1","0","1","1"));
                } else {
                    temp.addAll(List.of("0","0","0","0","0"));
                }
            }
            now +=1;
            numberList = temp;
        }
        int result = 0;
        for (int i=0; i<numberList.size(); i++) {
            if (i >l-1 && i < r && Objects.equals(numberList.get(i), "1")) {
                result++;
            }
        }
        return result;
    }
    // 규칙을 찾으면 쉬운 문제 였음
}
