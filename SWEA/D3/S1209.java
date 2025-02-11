import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1209 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

       


        for(int t = 1; t<=10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int N = 100;
            int[][] arr = new int[N][N];
            for(int i = 0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken(" "));
                }
            } // arr 값 초기화 loop



      

           int max = 0;
           int temp3 =0;
           int temp4 =0;
            for(int i = 0; i<N; i++) {
                int temp1 = 0;
                int temp2 = 0;
                for(int j = 0; j<N; j++) {
                    
                    //행우선
                    temp1 +=arr[i][j];
                    
                    // 열우선
                    temp2 += arr[j][i];
                }
                if(temp1 > max) {
                    max = temp1;
                }
                if(temp2 > max) {
                    max = temp2;
                }
                // 정방향 대각선.
                    temp3 += arr[i][i];

                    // 역방향 대각선.
                    temp4 += arr[i][N-1-i];
            } // 배열 탐색하면서 더함
        
            if(temp3 > max) {
                max = temp3;
            }   
            if(temp4 > max) {
                max = temp4;
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
            
            


        } // tc loop

        bw.write(sb.toString());
        bw.flush();





    }
}