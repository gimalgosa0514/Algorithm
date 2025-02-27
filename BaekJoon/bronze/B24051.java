import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24051 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        // 삽입 정렬은 카드를 정리하는 것과 같음.
        // 하 이게 근데, 슈도코드 잘 못읽어서 개 곱창 났는데.. 이렇게 하면 됨 ㅠ
        for(int i = 1; i<N; i++) {
            int idx = i-1;
            int item = arr[i];

            while(0<=idx && item < arr[idx]) {
                
                arr[idx+1] = arr[idx];
                count++;
                if(count == K) {
                    bw.write(String.valueOf(arr[idx]));
                    bw.flush();
                    bw.close();
                    return;
                }
                idx--;
                
                
            }
            if(idx +1 != i) {
                arr[idx+1] = item;
                count++;
                if(count == K) {
                    bw.write(String.valueOf(item));
                    bw.flush();
                    bw.close();
                    return;
                }
            }




            

        }

     
        bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }
}
