import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15649 {


    static int N;
    static int M;
    static boolean[] visited;
    static int[] result;
    static int idx;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        result = new int[M];
        perm(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }



    public static void perm(int start) {


        if(idx == M) {
            for(int n : result) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }


        if(start == N+1) {
            return;
        }
        

     
        for(int i = 1; i<=N; i++) {

            if(!visited[i]) {                
                visited[i] = true;
                result[idx] = i;
                idx++;
                perm(start+1);
                visited[i] = false;
                idx--;
            }
        }


    }

}