import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24052 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i<N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while(0<=loc && newItem < arr[loc]) {
                arr[loc+1] = arr[loc];
                K--;
                if(K == 0) {
                    for(int j = 0; j<N; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    return;
                }
                loc--;  
            }

            if(loc+1 != i) {
                arr[loc + 1] = newItem;
                K--;
                if(K==0) {
                    for(int j = 0; j<N; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    return;
                }
              
            }

        }

        bw.write("-1");
        bw.flush();
        bw.close();

    }
}
