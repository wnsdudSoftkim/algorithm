public class 이진탐색 {
    public static void main(String[] args) {
        binarySearch({1,2,3}, 2);
    }
    static void binarySearch(int[] arr, int key) {
        int left=0;
        int right = arr.length-1;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(key==arr[mid]){
                System.out.println(arr[mid]);
                break;
            }else if(key<arr[mid]){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
    }
}
//2.  Arrays.binarySearch 표준라이브러리 사용