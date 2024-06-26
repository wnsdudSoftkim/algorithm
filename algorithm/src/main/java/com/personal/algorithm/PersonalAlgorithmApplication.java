package com.personal.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
@SpringBootApplication()
@EnableScheduling
@EnableRetry
@EnableAspectJAutoProxy
public class PersonalAlgorithmApplication {
    public static void main(String[] args) {
        solution();
    }
    static boolean[][] visited;
    static int[][] graph;
    static Map<Integer, Integer> result = new HashMap<>();
    static int X;
    static int Y;

    public static int[] solution() {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        graph = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        X = maps.length;
        Y = maps[0].length() ;
        for (int i = 0; i< maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                String ch = String.valueOf(maps[i].charAt(j));
                if(ch.equals("X")) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.parseInt(ch);
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
        if (visited[row][column]) {
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