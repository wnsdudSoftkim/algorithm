package com.personal.algorithm.problem;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/31/24
 */
public class 무인도여행_프로그래머스 {
    static boolean[][] visited;
    static int[][] graph;
    static Map<Integer, Integer> result = new HashMap<>();
    static int X;
    static int Y;
    /*
        정확성: 48.0
        합계: 48.0 / 100.0
     */

    public static int[] solution() {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        graph = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        X = maps.length;
        Y = maps[0].length() ;
        for (int i = 0; i< maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Character.getNumericValue(ch);
                }
            }
        }
        for (boolean[] visit: visited) {
            Arrays.fill(visit, false);
        }
        for (int i = 0; i< maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                check(i,j, i+j);
            }
        }
        Stream<Integer> resultStream = result.values().stream().filter(e -> e >0);
        if (resultStream.findAny().isPresent()) {
            return result.values().stream().filter(e -> e >0).sorted().mapToInt(e -> e).toArray();
        }
        return new int[]{-1};
    }
    private static void check(int row, int column, int index) {
        if (visited[row][column] || graph[row][column] == 0) {
            return;
        }
        visited[row][column] = true;
        result.merge(index, graph[row][column], Integer::sum);
        if (graph[row][column] != 0) {
            int[][] around = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for (int[] ar: around) {
                int x = ar[0] + row;
                int y = ar[1] + column;
                if (x >=0 && y>=0 && x<X && y < Y) {
                    check(x, y, index);
                }
            }
        }
    }
}
