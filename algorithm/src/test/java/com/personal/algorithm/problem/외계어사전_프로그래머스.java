package com.personal.algorithm.problem;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 외계어사전_프로그래머스 {
    public int solution(String[] spell, String[] dic) {
        for (String word: dic) {
            int count =0;
            for (String sp: spell) {
                if (word.contains(sp)) {
                    count++;
                }
            }
            if (count >=spell.length) return 1;
        }
        return 2;

    }
}
