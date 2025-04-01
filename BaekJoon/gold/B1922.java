package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1922 {

    static int[] p;

    static class Edge implements Comparable<Edge> {


        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
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
    
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[M];
        
        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            edges[i] = new Edge(a,b,c);
        } // 간선 배열 초기화


        Arrays.sort(edges);

        int ans = 0;
        int pick = 0;
        p = new int[N+1];        
        
        for(int i = 1; i<=N; i++) {
            p[i] = i;
        }


        for(int i = 0; i<M && pick <= N-1; i++) {
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
