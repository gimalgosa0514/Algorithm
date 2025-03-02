package test.Month;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,6,5,2,3};

        for(int i = arr.length-1; i>0; i--) {
            for(int j =0; j<i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
