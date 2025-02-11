import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1210 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        while(true) {


            int tc = Integer.parseInt(br.readLine());

            int N = 100;
            
            
            int[][] ladders = new int[N][N];

            int exitC = -1;
            for(int i = 0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    ladders[i][j] = Integer.parseInt(st.nextToken(" "));

                    // 출구 미리 찾아놓음.
                    if(ladders[i][j] == 2) {
                        exitC = j;
                    }
                }
            }

            int j = exitC;
            for(int i = N-1; i>=0; i--) {
                
                
                boolean flag = true;

                // 증감식 헷갈릴거 같으면 그냥 첨부터 이렇게 하셈..
                int left = j-1;
                int right = j+1;

                while(flag) {
                    
                    // 좌, 우 중에 갈 수 있는 곳 가서  0 만날때 까지 가면 됨.
                    
                    if(left >= 0 && ladders[i][left] != 0) {
                        // 증감식 자신 없으면 걍 이렇게 해라 진짜 뒤 1 지기 싫으면
                        j = left;
                        left--;
                        
                        continue;


                    // 우로 가잇!    
                    } else if(right <N && ladders[i][right] != 0) {
                        
                        j = right;
                        right++;
                        continue;

                    } else { //아무데도 못가면 조건문 나와
                        flag = false;
                    }
            
                    

                }
                
            }

            
         
            sb.append("#").append(tc).append(" ").append(j).append("\n");






            if(tc == 10) break;
        } // tc에 10이 들어올 때 까지 반복

        bw.write(sb.toString().trim());
        bw.flush();

    }
}