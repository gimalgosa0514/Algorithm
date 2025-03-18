import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24060 {

    static int N;
    static int K;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[N];
        String[] inputs = br.readLine().split(" ");

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        mergeSort(0, N-1);

        if(K > 0) {
            bw.write("-1");
        } else {
            bw.write(sb.toString());
        }
        
        bw.flush();
        bw.close();
        

    }


    public static void mergeSort(int start, int end) {
        if(start<end) {
            int mid = (start + end) / 2;

            mergeSort(start,mid);
            mergeSort(mid+1,end);

            merge(start,mid,end);
            
        }
    }


    public static void merge(int start, int mid, int end) {

        int L = start;
        int R = mid+1;
        int idx = start;

        while(L <=mid && R <=end) {

            if(arr[L] <= arr[R]) {
                temp[idx++] = arr[L++];
                K--;
                if(K == 0) {
                    sb.append(temp[idx-1]);
                }
            } else {
                temp[idx++] = arr[R++];
                K--;
                if(K == 0) {
                    sb.append(temp[idx-1]);
                }
            }
        }

        
        // L 덜뺀거니까 마져 빼 줌.
        while(L<=mid) {
            temp[idx++] = arr[L++];
            K--;
                if(K == 0) {
                    sb.append(temp[idx-1]);
                }
        }

        // R 덜뺀거니까 마져 빼 줌.
        while(R<=end) {
            temp[idx++] = arr[R++];
            K--;
                if(K == 0) {
                    sb.append(temp[idx-1]);
                }
        }


        // 끝내고 나면 결과 arr에 저장.
        for(int i =start; i<=end; i++) {
            arr[i] = temp[i];
        }


    }
}