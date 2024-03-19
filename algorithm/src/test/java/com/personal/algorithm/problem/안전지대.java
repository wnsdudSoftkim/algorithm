package com.personal.algorithm.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/18/24
 */
public class 안전지대 {

    @Test
    public int solution(int[][] board) {
        int max = board.length;

        for (int i=0; i< board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if (board[i][j] == 1) {

                }
            }
        }
        return max;
    }

    public void visit(int[][] board, int i, int j, int max) {
        board[i][j] = 2;
        if (i>1) {
            board[i-1][j] = 2;
            if (j>1) {
                board[i-1][j-1] = 2;
                board[i][j-1] = 2;
                if (i<max) {
                    board[i+1][j-1] = 2;
                    board[i+1][j] = 2;
                }
            }
        }
        if (i>1 && j>1) {
            board[i-1][j-1] = 2;
        }
    }
    public int solution3(int[][] board) {
        int [][] visited = new int [board.length][board.length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j] ==1) check(i,j,visited);
            }
        }
        return 0;
    }

    private void check(int x, int y, int[][] visited) {
        int[] aroundX = {0,0,0,1,1,1,-1,-1,-1};
        int[] aroundY = {0,1,-1,0,1,-1,0,1,-1};
        for (int i=0; i< 9; i++) {
            int realX = x + aroundX[i];
            int realY = y + aroundY[i];
            if (realX < visited.length && realY < visited.length) {
                if (realX >= 0 && realY >=0) visited[realX][realY] = 1;
            }
        }
    }


//    public int solution2(int[][] board) {
//        int[][] boomBoard = new int[board.length][board.length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 1) checkExplosion(i, j, boomBoard);
//            }
//        }
//
//        int count = 0;
//        for (int[] array : boomBoard) {
//            for (int value : array) {
//                if (value == 0) count++;
//            }
//        }
//        return count;
//    }
//
//    static void checkExplosion(int x, int y, int[][] boomBoard) {
//        int explosionX;
//        int explosionY;
//        int[] aroundX = {0, -1, -1, -1, 0, 0, 1, 1, 1};
//        int[] aroundY = {0, -1, 0, 1, -1, 1, -1, 0, 1};
//        for (int i = 0; i < 9; i++) {
//            explosionX = x + aroundX[i];
//            explosionY = y + aroundY[i];
//            if (explosionX < boomBoard.length && explosionY < boomBoard.length)
//                if (explosionX >= 0 && explosionY >= 0) boomBoard[explosionX][explosionY] = 1;
//        }
//    }
}
