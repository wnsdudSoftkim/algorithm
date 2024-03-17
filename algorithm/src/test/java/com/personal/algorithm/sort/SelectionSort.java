package com.personal.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class SelectionSort {
    /*
        맨 앞 인덱스부터 차례대로 들어갈 원소를 선택하여 정렬하는 알고리즘이다.
        교환 횟수는 O(n)으로 적지만, 비교는 모두 진행된다.
        즉, 버블 정렬보다는 성능이 좋다.
        인덱스 0 ~ (n - 1)을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
        인덱스 0과 가장 작은 인덱스의 원소를 swap()한다.
        다시 인덱스 1 ~ (n - 1)을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
        인덱스 1과 가장 작은 인덱스의 원소를 swap()한다.
        반복...
     */
    @Test
    void selectionSort() {
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
        /*
        worst: O(n^2)
        average: O(n^2)
        best: O(n^2)
         */
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}