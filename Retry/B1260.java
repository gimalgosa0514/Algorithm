package Retry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {

    static int N;
    static int line;
    static int V;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder bfsResult = new StringBuilder();
    static StringBuilder dfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i<line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
            
        }

   

        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
        bw.write(dfsResult.toString());
        bw.write("\n");
        bw.write(bfsResult.toString());
        bw.flush();
        bw.close();

    }

    static void dfs(int start) {
        
        
        visited[start] = true;
        dfsResult.append(start).append(" ");
        for(int i = 1; i<N+1;i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

    static void bfs(int start) {
        
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            bfsResult.append(curr).append(" ");
            

            for(int i = 1; i<N+1; i++) {
                if(!visited[i] && arr[curr][i] == 1) {
                    visited[i] = true;  
                    q.add(i);
                }
            }
        }
    }

}
