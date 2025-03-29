package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S8275 {

    static int[] hamster;
    static int[][] note;
    static int N;
    static int X;
    static int M;
    
    static int[] ans;
    static int resultSum;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();




        int T = Integer.parseInt(br.readLine());


       

        for(int t = 1;  t<=T; t++) {

            // N, X, M 초기화
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 각 우리 수.
            X = Integer.parseInt(st.nextToken()); // 우리에 들어갈 수 있는 최대 햄스터 수 
            M = Integer.parseInt(st.nextToken()); // 기록에 대한 수.
            hamster = new int[N];
            note = new int[M][3];
            ans = new int[N];
            
            resultSum = -1;
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());

                note[i][0] = Integer.parseInt(st.nextToken())-1;
                note[i][1] = Integer.parseInt(st.nextToken())-1;
                note[i][2] = Integer.parseInt(st.nextToken());
                
            }
            
            find(0);

            if(resultSum == -1) {
                sb.append("#").append(t).append(" ").append("-1");
            } else {
                sb.append("#").append(t).append(" ");
                for(int i = 0; i<N; i++) {
                    sb.append(ans[i]).append(" ");
                }
            }
            sb.append("\n");
            

        } // tc loop
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void find(int depth) {

        // 깊이가 N이랑 같으면 나와줘야함.
        if(depth == N) {
            if(isOk()) {
                

                int currSum = 0;
                for(int j = 0; j<N; j++) {
                    currSum += hamster[j];
                }
                if(currSum > resultSum) {
                    for(int j = 0; j<N; j++) {
                        ans[j] = hamster[j];
                    }
                    resultSum = currSum;
                }
                
            }
            return;
        }

        for(int i = 0; i<=X; i++) {
            hamster[depth] = i;      
            find(depth+1);
        }
        

    }

    static boolean isOk() {

        for(int i = 0; i<M; i++) {
            int sum = 0;
            int from = note[i][0];
            int to = note[i][1];
            int cost = note[i][2];
            
            for(int j = from; j<=to; j++) {
                sum += hamster[j];
            }
            
            if(sum != cost) {
                return false;
            } 

        }

        

        return true;


    }


}
