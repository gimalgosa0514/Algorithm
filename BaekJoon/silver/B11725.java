import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[][] tree = new String[N+1][3];
        for(int i = 0; i<N-1; i++) {
            String[] commands = br.readLine().split(" ");
            
            String p = commands[0];
            String c = commands[1];

            // 왼쪽 노드
            if(tree[Integer.parseInt(p)][0] == null) {
                tree[Integer.parseInt(p)][0] = c;
            } else {
                tree[Integer.parseInt(p)][1] = c;
            }
            tree[Integer.parseInt(c)][2] = p;


        }

        for(int i = 1; i<=N-1; i++) {
            sb.append(tree[i][2]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
