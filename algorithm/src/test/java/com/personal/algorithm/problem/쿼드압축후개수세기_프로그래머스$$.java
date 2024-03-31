package com.personal.algorithm.problem;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/29/24
 */
public class 쿼드압축후개수세기_프로그래머스$$ {
    /*
    분할정복
    1. 작은 영역으로 나누기
    2. 나누어진 작은 영역 계산
    3. 필요시 해결된 답 모으기
     */
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dq(0,0,totalSize, arr);
        return answer;
    }

    private void dq(int startX, int startY, int size, int[][] arr) {
        if (check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }
        dq(startX, startY, size/2, arr);
        dq(startX + size/2, startY, size/2, arr);
        dq(startX, startY + size/2, size/2, arr);
        dq(startX + size/2, startY + size/2, size/2, arr);
    }

    private boolean check(int x, int y, int size, int[][] arr) {
        for (int i=x; i< x+ size; i++) {
            for (int j= y; j< y+size; j++) {
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }

}
