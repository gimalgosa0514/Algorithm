package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {

    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        List<Integer>[] adj = new ArrayList[N+1];

        for(int i = 0; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }


        int[] degree = new int[N+1];
        


        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            degree[to]++;
        }

        
        // 1. 큐 안에 진입차수가 0인 애들을 넣어둠.
        Queue<Integer> q = new LinkedList<>();


        for(int i = 1; i<=N; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }


        while(!q.isEmpty()) {
            
            int curr = q.poll();
            sb.append(curr).append(" ");
            for(int x : adj[curr]) {
                
                degree[x]--;
                if(degree[x] == 0) {
                    q.add(x);
                } 


            }

        

        } 

        bw.write(sb.toString());
        bw.flush();
        bw.close();




    }
}
