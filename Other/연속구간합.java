public class 연속구간합 {
    //1.무식하게 풀기
    static int inefficientMaxSum(int[] arr) {
        int max = 0;
        //시간복잡도 N^2
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = arr[i]+arr[j];
                max = Math.max(sum,max);
            }
        }
        return max;

    }
    //분할 정복 알고리즘 nlgn
    static int fastMaxSum(int[] arr) {
        int max=0;
        int mid=arr.length/2;
        for(int i=0; i<mid-1; i++){
            
            max = Math.max(arr[i]+arr[i+1], max);
        }
        for(int i=mid; i<arr.length-1;i++){
            max = Math.max(arr[i]+arr[i+1],max);
        }
        return max;
    }
    
}
