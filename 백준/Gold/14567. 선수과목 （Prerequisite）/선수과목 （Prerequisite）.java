

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 과목 수 
        int N = Integer.parseInt(st.nextToken());

        // 간선 수 -> 선수 조건 수
        int M = Integer.parseInt(st.nextToken());
        

        // 진입 차수 저장 배열
        int[] degree = new int[N+1];


        // 각 과목당 몇학기인지 저장.
        int[] semesters = new int[N+1];
        Arrays.fill(semesters, 1);        

        

        // 큐
        Queue<int[]> q = new LinkedList();

        List<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
        } // 인접 리스트 초기화


        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            degree[b]++;
        }


        for(int i = 1; i<=N; i++) {
            if(degree[i] == 0) {
                q.add(new int[] {i,1});
            } // 진입차수가 0이다? 즉 최 우선으로 해야하는 작업이다.
        }

        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            int currNode = curr[0];
            int semester = curr[1];

            semesters[currNode] = semester;
            for(int x : adj[currNode]) {
                degree[x]--;
                if(degree[x] == 0) {
                    q.add(new int[] {x, semester+1});
                }
            }

        }





        for(int i = 1; i<=N; i++) {
            sb.append(semesters[i]).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();


        
    }
}
