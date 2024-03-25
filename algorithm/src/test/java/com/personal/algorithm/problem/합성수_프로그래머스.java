package com.personal.algorithm.problem;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/19/24
 */
public class 합성수_프로그래머스 {

    public int solution(int n) {
        int answerCount = 0;
        for (int i = 4; i <= n; i++) {
            if (isValue(i)) {
                answerCount++;
            }
        }
        return answerCount;
    }

    public static boolean isValue(int number) {
        int count = 0;
        for (int i = 1; i<=Math.sqrt(number); i++) {
            if (i*i ==  number) count++;
            else if (number%i ==0) count +=2;
        }
        return count >= 3;
    }

}
