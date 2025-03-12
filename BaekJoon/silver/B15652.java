import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15652 {

    static int N;
    static int M;

    static int[] sel;
    static int idx;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M];
        sel = new int[M];
        comb(1,0);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    static void comb(int start,int sIdx) {
        

        if(sIdx == M) {
            for(int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(start == N+1) {
            return;
        }

        
        sel[sIdx] = start;
        comb(start,sIdx+1);

        
        comb(start+1,sIdx);


    }

}
