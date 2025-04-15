import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i<M; i++) {
            String str = br.readLine();
            for(int j = 0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0;i<N; i++) {
            if(map[0][i] == '0' && !visited[0][i]) {
                dfs(0,i);
            }
        }

        for(int i = 0; i<N; i++) {
            if(visited[M-1][i]) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");


    }


    public static void dfs(int sr, int sc) {
        visited[sr][sc] = true;

        for(int i = 0; i<4; i++) {
            int nr = sr+dr[i];
            int nc = sc+dc[i];


            if(nr<0 || nr>=M || nc<0 || nc>=N) continue;


            if(visited[nr][nc]) continue;

            if(map[nr][nc] == '1') continue;

            dfs(nr,nc);
            

        }

    }
}