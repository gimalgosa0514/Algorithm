package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2644 {

    static int N;
    static int A;
    static int B;
    static int line;
    static int[][] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        line = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i<line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }


        dfs(A,0);

        if(result == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        }


        
        bw.flush();
        bw.close(); 
    }

    static void dfs(int start, int cnt) {
        
        if(start == B) {
            result= cnt;
            return;
        }
        visited[start] = true;

        for(int i = 1; i<arr[start].length; i++) {
            if( !visited[i] && arr[start][i] == 1) {

                // ++ 난사하지마라... 
                dfs(i,cnt+1);
            }
        }
    }
}
