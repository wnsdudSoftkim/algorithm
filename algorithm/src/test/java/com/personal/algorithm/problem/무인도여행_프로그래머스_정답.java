package com.personal.algorithm.problem;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Stream;
/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/31/24
 */
public class 무인도여행_프로그래머스_정답 {
    static boolean[][] visited;
    static int[][] graph;
    static int X, Y;

    public static int[] solution(String[] maps) {
        X = maps.length;
        Y = maps[0].length();
        graph = new int[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Character.getNumericValue(ch);
                }
            }
        }

        List<Integer> islandDays = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    islandDays.add(dfs(i, j));
                }
            }
        }

        if (!islandDays.isEmpty()) {
            Collections.sort(islandDays);
            return islandDays.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[]{-1};
        }
    }

    private static int dfs(int row, int column) {
        visited[row][column] = true;
        int sum = graph[row][column];
        int[][] around = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] ar : around) {
            int x = ar[0] + row;
            int y = ar[1] + column;
            if (x >= 0 && y >= 0 && x < X && y < Y && !visited[x][y] && graph[x][y] != 0) {
                sum += dfs(x, y);
            }
        }
        return sum;
    }
}
