package SWEA.D6;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1267 {
    
    static int V;
    static int E;
    static List<Integer>[] adj;
    static boolean[] visited;
    static Stack<Integer> ans;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        

        

        
        for(int t = 1; t<=10; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            
            adj = new ArrayList[V+1];
            visited = new boolean[V+1];
            ans = new Stack<>();

            for(int i = 0; i<=V; i++) {
                adj[i] = new ArrayList<>();
            } // adj 초기화
            int[] degree = new int[V+1];

            
            
            st = new StringTokenizer(br.readLine());


            for(int i = 0; i<E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                adj[from].add(to); 
                degree[to]++;
            }
       

            

            for(int i = 1; i<=V; i++) {

                if(degree[i] == 0) {
                    dfs(i);
                }
            }


            while(!ans.isEmpty()) {
                sb.append(ans.pop()).append(" ");
            }
            sb.append("\n");

        } // tc
        
        bw.write(sb.toString());
        bw.flush();
        bw.close(); 
        

    }


    static void dfs(int start) {
        
        visited[start] = true;

        for(int x : adj[start]) {
            if(!visited[x]) {
                dfs(x);
            }
        }

        ans.push(start);


    }

}