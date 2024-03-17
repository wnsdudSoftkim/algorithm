package com.personal.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class InsertionSort {
    /*
        인덱스 1의 원소부터 앞 방향으로 들어갈 위치를 찾아 교환하는 정렬 알고리즘이다.
        정렬이 되어 있는 배열의 경우 O(n)의 속도로 정렬되어 있을 수록 성능이 좋다.

        인덱스 1 ~ (n - 1) 의 원소들을 순차적으로 자신이 들어갈 위치에 넣는다.
        while문을 사용하여 더 작으면 계속 앞으로 전진시키면서 비교한 원소를 한 칸씩 뒤로 민다.
        들어갈 자리가 정해지면 넣어준다.
     */
    @Test
    void insertionSort() {
        int[] arr = {1,2,3,4,5};
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        /*
            worst: O(n^2)
            average: O(n^2)
            best: O(n)
         */
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}