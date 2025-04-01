package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B9372 {

    static class Edge {
        
        int s;
        int e;

        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
    }

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            
            // M개의 간선
            Edge[] edges = new Edge[M];
            
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(s, e);
                
            } // 간선 배열 초기화
            
            sb.append(N-1).append("\n");


        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }   


    
}
