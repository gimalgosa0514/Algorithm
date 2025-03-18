import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B24061 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;
    
    static int[] arr;
    static int[] temp;
    
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

        mergeSort(0,N-1);

        if(K > 0) {
            bw.write("-1");
        } else {
            bw.write(sb.toString());
        }
        
        bw.flush();
        bw.close();

    }


    public static void mergeSort(int start, int end) {

        if(start < end) {

            int mid = (start+end) / 2;
            
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }


    }

    public static void merge(int start, int mid, int end) {

        int L = start;
        int R = mid+1;

        int idx = start;

        while(L <=mid && R <= end) {

            if(arr[L] <= arr[R]) {
                temp[idx++] = arr[L++];
             
                
            } else {
                temp[idx++] = arr[R++];
            }
        }




        while(L<=mid) {
            temp[idx++] = arr[L++];
        }

        while(R <= end) {
            temp[idx++] = arr[R++];
        }



        for(int i = start; i<=end; i++) {
            arr[i] = temp[i];
            K--;
            if(K == 0) {
                for(int j = 0; j<N; j++) {
                    sb.append(arr[j]).append(" ");
                }
            }
        }
      
        

    }


}
