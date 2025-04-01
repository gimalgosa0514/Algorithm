package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1647 {


    static final int INF = Integer.MAX_VALUE;


    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost) {
            
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        

    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 1. 인접 배열 생성
        List<Edge>[] adj = new ArrayList[n+1];

        for(int i = 0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        } // ArrayList 초기화


        // 2. 인접 배열에 값 집어넣기
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Edge(e, cost));
            adj[e].add(new Edge(s,cost));

        }


        // 3. 트리의 소속인지 아닌지를 확인해야 하니 그걸 체크하기위해 방문 배열 하나 생성. 
        boolean[] visited = new boolean[n+1]; // 트리의 소속인지 아닌지를 기록해야하니깐.
        PriorityQueue<Edge> pq = new PriorityQueue<>();


        // 정답을 담을 변수 
        int ans = 0;

        // 이 문제에서는 마을을 두개로 나누면서 최소 관리 비용이 들도록 해야함.
        // 그럼 어떻게? MST는 에초에 싸이클이 없음. 제일 비용이 큰 길을
        // 없애버린다면? 마을이 두개로 나누어지게됨 그러면서 제일 유지비가 덜드는거임.
        // 그래서 이걸 찾기 위해 변수를 선언해 줌.
        int max = 0;


        // 4. 임의로 시작점을 정해야하는데 우리는 0으로 잡을꺼임 그래서 일단 하나를 고른거니 Pick을 1로 초기ㅗ하
        int pick = 1;
        visited[1] = true;

        // 5.  1번이랑 인접한 애들 다 집어넣어줌
        pq.addAll(adj[1]); 

        
        // 6. 이제 돌기 시작.
        while(pick < n) { // 정점의 수 - 1번 개만큼 골라야하니깐 

            Edge e = pq.poll();

            // 만약 선택했다? 그럼 넘겨
            if(visited[e.to]) continue;

            ans += e.cost;
            max = Math.max(max, e.cost);
            visited[e.to] = true;
            pick++;

            pq.addAll(adj[e.to]);

        }
    
        bw.write(String.valueOf(ans-max));
        bw.flush();
        bw.close();


    }
}
