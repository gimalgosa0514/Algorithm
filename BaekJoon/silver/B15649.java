import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15649 {

    static boolean[] visited;
    static int[] sel;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        sel = new int[M];
        perm(0);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    
    }

    public static void perm(int start) {
        if(start == M) {
            for(int i = 0; i<M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sel[start] = i;
                perm(start+1);
                visited[i] = false;
            }
        }



    }
    

}
