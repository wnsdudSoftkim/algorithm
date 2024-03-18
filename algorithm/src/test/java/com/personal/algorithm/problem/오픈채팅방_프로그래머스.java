package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 오픈채팅방_프로그래머스 {
    /*
    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
     */
    @Test
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> idNameMap = new HashMap<>();
        for (int i =0; i< record.length; i++) {
            String[] word = record[i].split(" ");
            if (!idNameMap.containsKey(word[1])) {
                idNameMap.put(word[1], word[2]);
            }
            if (Objects.equals(word[0], "Enter")) {
                String a = String.format("%s님이 들어왔습니다.", word[1]);
                idNameMap.put(word[1], word[2]);
                result.add(a);
            } else if (Objects.equals(word[0], "Leave")) {
                String a = String.format("%s님이 나갔습니다.", word[1]);
                result.add(a);
            }else if (Objects.equals(word[0], "Change")) {
                idNameMap.put(word[1], word[2]);
            }
        }
        return result.stream().map(message -> {
            String[] a = message.split("님");
            return message.replaceAll(a[0], idNameMap.get(a[0]));
        }).toArray(String[]::new);

    }
}
