package com.personal.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class BubbleSort {
    /*
    정렬 과정에서 거품이 수면으로 올라오는 모습과 흡사하여 지어진 이름이다.
    비교와 교환이 모두 일어날 수 있기 때문에 코드는 단순하지만 성능은 좋지 않다.
     */
    @Test
    void bubbleSort() {
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
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
