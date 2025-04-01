package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5643 {


    static int[][] adj;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            
            
            N = Integer.parseInt(br.readLine()); // 학생 수 
            M = Integer.parseInt(br.readLine()); // 간선 수
            adj = new int[N+1][N+1];
            
            for(int i = 0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a][b] = 1; // 방향 그래프임.
                // 에초에 한방향으로 쭉 흐를꺼니까 방문체크도 안해줘도 될 것 같음. ㅇㅇ

            } // 인접 배열 초기화


            
            for(int k = 1; k<=N; k++) {
                for(int i = 1; i<=N; i++) {
                    for(int j = 1; j<=N; j++) {
                        if(adj[i][k] == 1  && adj[k][j] == 1) {
                            adj[i][j] = 1;
                        }
                    }
                }
            }            


            int count = 0;

            for(int i = 1; i<=N; i++) {
                int small = 0;
                int tall = 0;

                for(int j = 0; j<=N; j++) {
                    if(adj[i][j] == 1) tall++;
                    if(adj[j][i] == 1) small++;
                }

                if(tall + small == N-1) {
                    count++;
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");


        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}