import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S14229 {
    // static final int N = 1000000;
    static final int N = 10;
    static int[] temp = new int[N];
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/SSAFY/Downloads/inp.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        // arr = new int[N];

        // StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        // // 배열 초기화.
        // for(int i = 0; i<N; i++) {
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }
        arr = new int[] {1,6,8,4,2,3,5,10,9,7};

        mergeSort(0, N-1);
        // bw.write(String.valueOf(arr[500000]));
        System.out.println(Arrays.toString(arr));
        bw.flush();
        bw.close();


    }

    static void mergeSort(int start, int end) {
        if(start<end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }


    static void merge(int start, int mid, int end) {

        int L = start;
        int R = mid+1;
        int idx = start;


        while(L<=mid && R<=end) {
            if(arr[L] <= arr[R]) {
                temp[idx++] = arr[L++];
            } else {
                temp[idx++] = arr[R++];
            }
        }


        if(L<= mid) {
            for(int i = L; i<=mid; i++) {
                temp[idx++] = arr[L++];
            }
        } else {
            for(int i = R; i<=end; i++) {
                temp[idx++] = arr[R++];
            }
        }


        for(int i = start; i<=end; i++) {
            arr[i] = temp[i];
        }

    }
    
}