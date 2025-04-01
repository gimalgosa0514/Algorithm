package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197 {


    static int[] p;

    static class Edge implements Comparable<Edge> {

        int s; // 시작
        int e; // 끝
        int cost; // 비용


        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.cost - o.cost;
        }

    }
    public static void main(String[] args) throws IOException {
       
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수


        // E만큼 엣지를 가지고 있음.
        Edge[] edges = new Edge[E]; 


        for(int i = 0; i<E; i++) {

            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());


            edges[i] = new Edge(s,e,cost);


        } // 주어지는 간선의 수 만큼 반복을 돌면서 edges 배열 초기화

        // cost가 최소인 애들 부터 시작할꺼임.
        Arrays.sort(edges); 

        int pick = 0;
        p = new int[V+1];
        int ans = 0;

        for(int i = 0; i<=V; i++) {
            p[i] = i;
        }


        for(int i = 0; i<E && pick<V-1; i++) {
            
            int s = edges[i].s;
            int e = edges[i].e;

            
            int px = findSet(s);
            int py = findSet(e);



            if(px != py) {
                union(px, py);
                pick++;
                ans += edges[i].cost;
            }


        }
        
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();


    }


    static int findSet(int x) {

        if(p[x] != x) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        p[y] = x;
    }


}

