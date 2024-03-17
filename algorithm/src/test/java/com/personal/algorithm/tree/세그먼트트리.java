package com.personal.algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
public class 세그먼트트리 {
    /*
        세그먼트 트리는 이름에서도 나타나듯이 트리 형태의 자료구조를 사용합니다
        숫자가 저장된 배열이 존재할 때 해당 배열의 구간 합을 구하거나, 배열의 특정 인덱스의 값을 변경한 후에 다시 구간합을 구해야 한다면 세그먼트 트리를 사용하는 것이 시간 복잡도 측면에서 적합합니다.

        세그먼트 트리(SegmentTree)의 초기화 작업은 재귀 메서드를 통해서 구현할 수 있습니다.
        부모 노드의 값은 자식 노드의 값을 더해서 표현할 수 있습니다.
        init메서드의 파라미터는 다음과 같은 의미를 가집니다.
        long[] arr : 세그먼트 트리(Segment Tree)로 나타낼 배열 (세그먼트 트리는 리프 노드에 배열의 값을 저장합니다.)
        int node : 메서드를 시작할 노드 인덱스 (항상 1번 인덱스부터 시작합니다.)
        int start : 세그먼트 트리(Segment Tree)의 노드들이 가지는 값의 시작 인덱스입니다.
        int end : 세그먼트 트리(Segment Tree)의 노드들이 가지는 값의 종료 인덱스입니다.

        세그먼트 트리(Segment Tree)의 각각의 노드들(리프 노드 제외)은 모두 배열의 특정 구간의 합을 의미합니다.
        예를 들어 문제에서 주어진 배열의 길이가 15라면 1번 노드는 0~14 인덱스의 합, 2번 노드는 0~7까지 3번 노드는 8~14까지 이런 식으로 각각의 노드들이 가지는 값은 배열의 특정 구간의 합을 의미합니다.
        즉, start와 end 파라미터는 노드가 가지는 값의 시작과 종료 인덱스를 의미한다고 생각하시면 됩니다.
        이제 init메서드를 통해 1번 노드부터 진행을 하면 재귀 형태로 리프 노드에 도달할 때까지 계속 호출되다가 리프 노드에 도달하면 노드가 가지는 인덱스를 통해 배열에서 값을 찾고 이를 노드에 저장 후 리턴합니다.
        값이 리턴되면 재귀 형태로 호출되었던 함수들이 종료되면서 차례로 각각의 노드들에 값이 저장됩니다.
        그리고 추가적으로 배열에서 자식 노드의 노드 번호는 다음과 같이 구할 수 있습니다.
        자식 노드 번호 (좌측) = 부모 노드 번호 * 2
        자식 노드 번호 (우측) = (부모 노드 번호 * 2) +1
     */
    @Test
    void segmentTree() {

    }

    static class SegmentTree {
        // 세그먼트 트리를 구현할 배열
        private long[] tree;

        // 생성자에서 세그먼트 트리의 전체 노드 수 계산 (즉, 배열 길이)
        // 세그먼트 트리의 높이 = logN(밑이 2인 로그)의 값을 올림 한 후 + 1
        // 세그먼트 트리의 전체 노드 수 = 2^(트리의 높이)
        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n)/Math.log(2)) +1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            // 트리의 길이 설정
            tree = new long[Math.toIntExact(treeNodeCount)];
        }
        long init(long[] arr, int node, int start, int end) {
            // 세그먼트 트리의 리프 노트인 경우
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                //리프 노드가 아닌 경우에는 자식노드의 값을 더해서 값 초기화 후 리턴
                return tree[node] = init(arr, node * 2, start, (start+end)/2)
                                    + init(arr, node*2+1, (start+end)/2+1, end);
            }
        }
        long sum(int node, int start, int end, int left, int right) {
            // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않을 경우 0 리턴
            if(end< left || right < start) {
                return 0;
            } else if (left<= start && end <= right) {
                // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하는 경우 노드 값 리턴
                return tree[node];
            } else {
                // 그 외는 2가지 경우가 존재
                // 1. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 일부는 속하고 일부는 속하지 않는 경우
                // 2. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간을 모두 포함하는 경우
                // 이와 같은 경우에는 자식노드를 탐색해서 값을 리턴
                return sum(node*2, start, (start+end)/2, left, right)
                        + sum(node*2+1, (start+end)/2+1, end, left, right);
            }
        }

        long update(int node, int start, int end, int index, long changeValue) {
            // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
            if (index < start || end < index) {
                return tree[node];
            } else if (start == index && end == index) {
                return tree[node] = changeValue;
            } else {
                // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)값이 포함되는 경우(같은 경우는 제외)
                // 자식 노드를 탐색 후 값을 더해서 리턴
                return tree[node] = update(node * 2, start, (start + end) / 2, index, changeValue) +
                        update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
            }
        }
    }

}