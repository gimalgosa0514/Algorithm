package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1003 {


    static int[][] memo;
    static int N;
    static int zeroCount;
    static int oneCount;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {

            N = Integer.parseInt(br.readLine());

            memo = new int[N+1][2];

            zeroCount = 0;
            oneCount = 0;

            memo[0] = new int[] {1,0};
            if(N > 0) {
                memo[1] = new int[] {0,1};
            }
            if(N> 1) {
                for(int i = 2; i<=N; i++) {
                    memo[i][0] = memo[i-1][0] + memo[i-2][0];
                    memo[i][1] = memo[i-1][1] + memo[i-2][1];
                }
            }
            


            sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
            
            

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }



}
