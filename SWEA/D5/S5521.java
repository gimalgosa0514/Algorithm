package SWEA.D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class S5521 {


    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T ; t++) {

            String[] inputs = br.readLine().split(" ");
            res = 0;
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];
            for(int i = 0; i<M; i++) {
                inputs = br.readLine().split(" ");
                int A = Integer.parseInt(inputs[0]);
                int B = Integer.parseInt(inputs[1]);

                arr[A][B] = arr[B][A] = 1;
            }

            bfs(1);

            sb.append("#").append(t).append(" ").append(res).append("\n");

        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    static void bfs(int start) {

        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {start, 0});

        while(!q.isEmpty()) {

            int[] curr = q.poll();
            visited[curr[0]] = true;

            for(int i = 1; i<arr[curr[0]].length; i++) {
                if(!visited[i] && arr[curr[0]][i] == 1 && curr[1] <=1) {
                    visited[i] = true;
                    q.add(new int[] {i, curr[1]+1});
                    res++;
                }
            }
        }
    }
}
