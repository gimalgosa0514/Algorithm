import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1966_CountingSort {
    public static void main(String[] args) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N];
            String[] strArr = br.readLine().split(" ");
            for(int i = 0; i<N; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }



            int max = Integer.MIN_VALUE;
            for(int i = 0; i<N; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
            
            int[] count = new int[max+1];

            for(int i = 0; i<N; i++) {
                count[arr[i]]++;
            }
            
            for(int i = 1; i<count.length; i++) {
                count[i] += count[i-1];
            }

            int[] sortedArr = new int[N];

            for(int i = N-1; i>=0; i--) {
                sortedArr[--count[arr[i]]] = arr[i]; 
            }




            sb.append("#").append(t).append(" ");
            for(int i = 0; i<N; i++) {
                sb.append(sortedArr[i]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
