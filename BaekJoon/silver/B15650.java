import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15650 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sel;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];

        comb(1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void comb(int idx,int sidx) {
        
        if(sidx == M) {
            for(int i = 0; i<M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(idx == N+1) {
            return;
        }

        sel[sidx] = idx;
        comb(idx+1, sidx+1);

        comb(idx+1,sidx);

    }
}
