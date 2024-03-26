package com.personal.algorithm.problem;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/26/24
 */
public class 바탕화면정리_프로그래머스$$ {
    public int[] solution(String[] wallpaper) {
        int minRow, minCol;
        int maxRow, maxCol;

        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                    maxRow = Math.max(maxRow, r);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        //max 값에 + 1을 하는 이유는 드래그를 하려면 끝점을 선택해야 함
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
    //dfs
    int gRow, gCol;
    int minRow, minCol;
    int maxRow, maxCol;
    char[][] gWallpaper;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[] solution2(String[] wallpaper) {
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;

        gRow = wallpaper.length;
        gCol = wallpaper[0].length();
        gWallpaper = new char[gRow][gCol];

        int idx = 0;
        for (String str : wallpaper) {
            gWallpaper[idx] = str.toCharArray();
            idx++;
        }

        for (int r = 0; r < gRow; r++) {
            for (int c = 0; c < gCol; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    dfs(r, c);
                }
            }
        }

        //max 값에 + 1을 하는 이유는 드래그를 하려면 끝점을 선택해야 함
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }

    private void dfs(int r, int c) {
        if (r < minRow) {
            minRow = r;
        }
        if (r > maxRow) {
            maxRow = r;
        }
        if (c < minCol) {
            minCol = c;
        }
        if (c > maxCol) {
            maxCol = c;
        }

        gWallpaper[r][c] = '!';

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];

            if (newR < 0 || newR >= gRow || newC < 0 || newC >= gCol || gWallpaper[newR][newC] != '#')
                continue;

            dfs(newR, newC);
        }
    }
}
