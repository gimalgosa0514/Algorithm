import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2606 {

    static int node;
    static int line;
    static int start;
    static int[][] arr;

    static boolean[] checked;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        start = 1;
        arr = new int[node+1][node+1];
        checked = new boolean[node+1];
        for(int i =0; i<line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
    

        dfs(start);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }

    public static void dfs(int start) {

        checked[start] = true;

        for(int i = 1; i<=node; i++) {
            if(arr[start][i] == 1 && !checked[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}
