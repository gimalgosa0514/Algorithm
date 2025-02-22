import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_RE {

    static int node;
    static int line;
    static int start;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start =  Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];


        for(int i = 0; i<line; i++) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(inputs.nextToken());
            int b = Integer.parseInt(inputs.nextToken());
            
            arr[a][b] = arr[b][a] = 1; // 연결
        }

        
        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];

        bfs(start);

        bw.write(sb.toString());
        bw.flush();
        bw.close();



    }

    public static void dfs(int start) {

        check[start] = true;
        sb.append(start).append(" ");

        for(int i = 1; i<=node; i++) {
            if(arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;
        
        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start).append(" ");

            for(int i = 1; i<=node; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }



        }
        


    }

}
