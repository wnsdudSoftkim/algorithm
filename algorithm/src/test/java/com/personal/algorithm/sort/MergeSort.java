package com.personal.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class MergeSort {
    /*
        분할 정복 알고리즘 중 하나이다.
        배열의 길이가 1이 될 때까지 2개의 부분 배열로 분할한다.
        분할이 완료됐으면 다시 2개의 부분 배열을 합병하고 정렬한다.
        모든 부분 배열이 합병될 때 까지 반복한다.
        시간 복잡도가 O(nlog n)으로 빠르지만, 아래 코드를 보면 tmpArr을 사용해야 돼서 제자리 정렬보다 O(n)만큼 추가적인 메모리가 사용되는 단점이 있다.
        보통은 재귀함수로 구현하므로 이 것또한 메모리를 많이 사용하게 된다.
        시간 복잡도
            worst: O(nlog n)
            average: O(nlog n)
            best: O(nlog n)
        공간 복잡도
            O(n)만큼의 추가 메모리 tmpArr 사용
     */
//    @Test
//    void mergeSort() {
//
//    }

    public static void sortByMergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }
    public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(arr, tmpArr, left, m);
            mergeSort(arr, tmpArr, m + 1, right);
            merge(arr, tmpArr, left, m, right);
        }
    }
    public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmpArr[i] = arr[i];
        }
        int part1 = left;
        int part2 = mid + 1;
        int index = left;
        while (part1 <= mid && part2 <= right) {
            if (tmpArr[part1] <= tmpArr[part2]) {
                arr[index] = tmpArr[part1];
                part1++;
            } else {
                arr[index] = tmpArr[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmpArr[part1 + i];
        }
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}