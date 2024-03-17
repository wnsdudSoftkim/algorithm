package com.personal.algorithm;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class BinarySearch {

    @Test
    void binarySearch() {

    }

    private boolean bSearchRecursive(int[] arr, int n, int left, int right) {
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (arr[mid] < n) {
            return bSearchRecursive(arr, n, mid +1, right);
        } else if (arr[mid] > n) {
            return bSearchRecursive(arr, n, left, mid -1);
        } else {
            return true;
        }
    }
}
