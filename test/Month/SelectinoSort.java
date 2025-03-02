package test.Month;

import java.util.Arrays;

public class SelectinoSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,4,3,5};


        for(int i =0; i<arr.length-1; i++) {
            
            int minIdx = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        } 
        System.out.println(Arrays.toString(arr));
    }
}
