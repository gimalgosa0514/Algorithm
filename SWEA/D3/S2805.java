import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2805 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=T; t++) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] str = br.readLine().split("");
                
                for(int j = 0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            } // 배열 초기화


            
            int sum = 0 ;
            
            int j = arr.length/2; // 얘부터 뻗어나갈꺼임.


            
            for(int i = 0; i<N; i++) {
                sum += arr[i][j];

                // i가 j보다 커지면 줄어들어야함.
                if(i <= j) {
                    for(int k=1; k<=i; k++) {
                        sum += arr[i][j+k];
                        sum += arr[i][j-k];
                    }
                    
                } else {
                    for(int k = 1; k<arr.length-i; k++) {
                        sum += arr[i][j+k];
                        sum += arr[i][j-k];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");


            






        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();;


    }
}
