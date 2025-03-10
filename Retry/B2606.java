package Retry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606 {

    static int N;
    static int line;
    static int[][] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        line = Integer.parseInt(br.readLine());

        for(int i = 0; i<line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        bfs(1);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int i = 0; i<arr[curr].length; i++) {
                if(!visited[i] && arr[curr][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                    result++;
                }
            }
        }



    }
}
