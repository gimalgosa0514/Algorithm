import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {

    static int node;
    static int line;
    static int start;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 노드의 간선을 표현 해주기 위한 2차원 배열. 
        arr = new int[node+1][node+1]; // 인접행렬방식이라 해서 연결이 되어있으면 1 뭐 이런시긍로 펴햔

        check = new boolean[node+1]; // 방문을 체크할 배열.
        
        for(int i = 0; i<line; i++) {
            // 인풋을 읽어들일 칭구.
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(inputs.nextToken());
            int b = Integer.parseInt(inputs.nextToken());
            arr[a][b] = arr[b][a] = 1; // a,b b,a의 연결 여부를 1로 표기해놓음 즉 연결되어있다.
        }

        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];
        bfs(start);
        bw.write(sb.toString());
        bw.flush();


    }


    public static void dfs(int start) {
        check[start] = true; // 시작 위치를 방문 처리함.
        sb.append(start + " "); // 방문한거 집어넣어줌.

        for(int i = 1; i<=node; i++) {
            if(arr[start][i] == 1 && !check[i]) { // 시작 위치랑 i번째 노드가 연결되어있는데 방문하지 않았다?
                // 그럼 dfs 해야함.
                dfs(i);
            }
        }

    }


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
