package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B24062 {

    static int N;
    static int[] original;
    static int[] arr;
    static int[] temp;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        original = new int[N];

        String[] inputs = br.readLine().split(" ");

        for(int i = 0; i<N; i++) {
            original[i] = Integer.parseInt(inputs[i]);
        }
        
        inputs = br.readLine().split(" ");

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }


        mergeSort(0,N-1);
        


    }

    public static void mergeSort(int start, int end) {

        if(start<end) {

            int mid = (start+end) / 2;

            mergeSort(start,mid);
            mergeSort(mid+1, end);

            merge(start,mid,end);
            
        }
    }

    public static void merge(int start, int mid, int end) {

        int L = start;
        int R = mid+1;
        int idx = start;

        while(L <= mid && R <= end) {
            if(arr[L] <= arr[R]) {
                temp[idx++] = arr[L++];
            } else {
                temp[idx++] = arr[R++];
            }
        }

        
        while(L <= mid) {
            temp[idx++] = arr[L++];
        }

        while(R <= end) {
            temp[idx++] = arr[R++];
        }


        for(int i = start; i<=end; i++) {
            arr[i] = temp[i];
        }


    }

}
