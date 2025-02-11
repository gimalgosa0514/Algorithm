import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1913 {

    public static void main(String[] args) throws IOException {
        


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        
        int[][] snail = new int[N][N];

        int step = 0;
        int r = N/2;
        int c = N/2;
        int num = 1;
        int dir = 1;


       snail[r][c] = num++;
       while(true) {
            
            

            // 수직 -> 수평
            for(int i = step; i>0; i--) {
                
                r += dir;

                if(num > N * N ) break;
                snail[r][c] = num++;
            }

            if(num > N * N ) break;
        
          
  

            // 수평 -> 수직
            for(int i = 0; i<step; i++) {
                c -= dir;
                
                if(num > N * N ) break;
                snail[r][c] = num++;
            }


            
            if(num > N * N ) break;
            dir = -dir;

          

            
            step++;
        }

        int ansI = -1;
        int ansJ = -1;
        for(int i = 0 ;i<N; i++) {
            for(int j = 0; j<N; j++) {
               if(target == snail[i][j]) {
                    ansI = i;
                    ansJ = j;
               }

               sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(ansI+1).append(" ").append(ansJ+1);
        bw.write(sb.toString());
        bw.flush();
    }
}