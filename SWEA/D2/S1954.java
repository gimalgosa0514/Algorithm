import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1954 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        int tc = Integer.parseInt(br.readLine());



        for(int t = 1; t<=tc; t++) {
            
            
            
            int N = Integer.parseInt(br.readLine());


            int K = N; // K > K-1 > k-2 이렇게 쭉쭉 가야지
            int dir = 1; // 얘는 방향을 위한 애. +1 을 하냐 -1을 하냐에 따른거지.
            int num = 1; // 얘는 달팽이로 찍을 그거임.
            
            // 얘네 둘은 인덱스
            int r = 0; 
            int c = -1; 

            //이제 돌아야함.

            int[][] snail = new int[N][N]; // 정답을 저장할 배열.
            
            while(true) {

                // 수평 수직 부터 돌아야쥬
                
                for(int i = 0; i< K;  i++) {
                    c+=dir;
                    snail[r][c] = num++;
                }

                // n * n 보다 커야한다.
                if(num > N*N) {
                    break;
                }

                
                // 이제 수직 -> 수평 
                
                // 이제 값 감소 시켜줘야함.
                K--;

                for(int i = 0; i<K; i++) {
                    r +=dir;
                    snail[r][c] = num++;
                }


                dir = -dir;



            }



            sb.append("#").append(String.valueOf(t)).append("\n");
            
            
            
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    sb.append(String.valueOf(snail[i][j])).append(" ");
                }
                sb.append("\n");
            }

          

        }


        

        bw.write(sb.toString());
        bw.flush();


        
    }
}
