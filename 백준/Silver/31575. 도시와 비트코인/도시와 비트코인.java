import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int M;

    static int[][] map;
    static boolean result;
    static boolean[][] visited;
    
    // 하, 우
    static int[] dr = {1,0};
    static int[] dc = {0,1};



    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N;j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } 


        dfs(0,0);


        if(result) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    public static void dfs(int startY, int startX) {

        if(startY == M-1 && startX == N-1) {
            result = true;
            return;
        }

        visited[startY][startX] = true;

        for(int i = 0; i<2; i++) {
            int nextY = startY + dr[i];
            int nextX = startX + dc[i];

            if(nextY >=M || nextX >=N) continue;

            if(visited[nextY][nextX]) continue;

            if(map[nextY][nextX] == 0) continue;


            dfs(nextY,nextX);

        }




    }

}
