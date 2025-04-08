import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 노드 수.
        map = new int[N][N];
        int[] dist = new int[N]; // 거리임.
        int[] p = new int[N]; // 부모정보겠징
        boolean[] visited = new boolean[N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        
        } // map 초기화.


        for(int i =0; i<N; i++) {
            dist[i] = INF;
            p[i] = -1; // 부모를 다 -1로 둬? 자기 자신이 아니라? 
        } // 거리 배열 초기화 
        
        // 2. 시작 정점 고르기

        dist[0] = 0;
        long ans = 0;
        // 3. 전체 반복문 수행 및 정점 뽑기
        for(int i = 0; i<N-1; i++) {
            int min = INF;
            int idx = -1;

            for(int j = 0; j<N; j++) {
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }

            visited[idx] = true;
           
            // 3-2 가장 작은 정점 뽑았으니까 연결된 간선 갱신
            for(int j = 0; j<N; j++) {
                if(!visited[j] && map[idx][j] != 0 && dist[j] > map[idx][j]) {
                    dist[j] = map[idx][j];
                    p[j] = idx;
                }
            }

        }
     
        for(int i = 0 ; i<N;i++) {
			ans+=dist[i];
		}
 
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
