package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 영어끝말있기_프로그래머스 {

    @Test
    public int[] solution(int n, String[] words) {
        int count =1;
        int target = -1;
        boolean flag = false;
        Map<Integer, List<String>> wordMap = new HashMap<>();
        for (int i=1; i<=n; i++) {
            wordMap.put(i, new ArrayList<>());
        }
        for (int i=0; i< words.length; i++) {
            int c = (i+1);
            if (i !=0) {
                String lastWord = words[i-1];
                String lastChar = lastWord.substring(lastWord.length() -1);
                String nowWord = words[i];
                String startChar = nowWord.substring(1);
                if (!lastChar.equals(startChar)) {
                    flag = true;
                    target = c%n;
                    break;
                }
                for (Map.Entry<Integer, List<String>> entry : wordMap.entrySet()) {
                    if (entry.getValue().contains(words[i])) {
                        flag = true;
                        target = c%n;
                        break;
                    }
                }
            }
            if (c%n ==0) {
                count ++;
            }
        }
        if (flag) {
            return new int[] {target, count};
        } else {
            return new int[] {0, 0};
        }
    }

    @Test
    public int[] solution3(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> wordList = new ArrayList<>();
        for (int i=0; i< words.length; i ++) {
            if (i != 0) {
                String s1 = words[i-1];
                String s2 = words[i];
                char last = s1.charAt(s1.length()-1);
                char first = s2.charAt(0);
                if (wordList.contains(s2) && last!= first) {
                    answer[0] = (i%n) +1;
                    answer[1] = (i/n) +1;
                    return answer;
                }
            }
            wordList.add(words[i]);
        }
        return answer;
    }

    @Test
    public int[] solution2(int n, String[] words) {
        int[] answer = {0, 0};

        //단어 중복 체크를 위한 맵
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            if(i != 0) {
                String s1 = words[i - 1]; // 이전 단어
                String s2 = words[i]; // 현재 단어

                char last = s1.charAt(s1.length() - 1); // 이전 단어의 마지막 철자
                char first = s2.charAt(0); // 현재 단어의 처음 철자

                if(map.containsKey(s2) || last != first) { // 단어가 중복이거나 철자가 이어지지 않는 경우
                    answer[0] = (i % n) + 1; // 번호
                    answer[1] = (i / n) + 1; // 차례

                    return answer;
                }
            }

            map.put(words[i], 1); // 사용한 단어 맵에 저장
        }

        return answer;
    }

}
