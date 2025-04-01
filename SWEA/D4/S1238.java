package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1238 {

    static boolean[] visited;
    static int[][] adj;
    static int line;
    static int start;
    



    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t<=10; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            line = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            
            adj = new int[101][101];
            visited = new boolean[101];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<line/2; i++) {
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                // 방향 그래프이니깐.
                adj[a][b] = 1;
                
            }

            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
            


        } // tc loop


        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


    static int bfs(int start) {

        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {start,0});
        visited[start] = true;
        

        int maxDepth = 0;
        int max = start;

        while(!q.isEmpty()) {

            int[] curr = q.poll();
            
            int node = curr[0];
            int depth = curr[1];
            
            if(depth > maxDepth) {
                maxDepth = depth;
                max = node;
            } else if(depth == maxDepth) {
                max = Math.max(max, node);
            }

            
            for(int i = 1; i<adj[node].length; i++) {

                if(!visited[i] && adj[node][i] == 1) {

                    q.add(new int[] {i,depth+1});
                    visited[i] = true;
                    
                }
            }

        }
        return max;

    }
}
