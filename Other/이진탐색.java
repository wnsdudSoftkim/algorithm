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
public static int binsearch(int[] a, int key, int left, int right) {
    int mid = (left+right)/2;
    if (a[mid] ==key) {
        return mid;
    }
    else if (a[mid] <key){
        return binsearch(a,key,left,mid-1);
    }
    else if (a[mid]>key){
        return binsearch(a,key,mid+1,right);
    }
    else return -1;
}
//2.  Arrays.binarySearch 표준라이브러리 사용