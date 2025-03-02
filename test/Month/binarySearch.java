package test.Month;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        
        int target = 9;
        int low = 0;
        int high = arr.length;
        while(low<=high) {

            int mid = (low+high) / 2;

            if(arr[mid] == target) {
                System.out.println("찾음~ : " + mid);
                return;
            } else if(arr[mid] > target) {
                high = mid-1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            }
        }

        System.out.println("못찾음 ㅠ");
        
    }
}
