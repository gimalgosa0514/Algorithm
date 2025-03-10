package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

    //상 하 좌 우 
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int result;
    static int N;
    static int M;

    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];
        //maze 초기화
        for(int i =0; i<N;i++) {
            String[] inputs = br.readLine().split("");

            for(int j = 0; j<M; j++) {
                maze[i][j] = Integer.parseInt(inputs[j]);
            }
        }


        dfs(0,0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void dfs(int startY, int startX) {
        Queue<int[]> q = new LinkedList<>();
        
        visited[startY][startX] = true;
        q.add(new int[] {startY,startX,1});
        while(!q.isEmpty()) {
           int[] curr = q.poll();
            int currY = curr[0];
            int currX = curr[1];
            int cnt = curr[2];
            // 도착지임.
            if(currY == N-1 && currX == M-1) {
                result = cnt;
                break;
            }
            
            //상하좌우를 검사하면서 갈 수 있는지 없는지 ㄱㄱ
            for(int i =0; i<4; i++) {   
                int nr = currY + dr[i];
                int nc = currX + dc[i];
           
                //일단 좌표상 문제 없다? 그럼 이제 갈 수 있는 길인지를 봄.
                if(nr >= 0 && nr<N && nc>=0 && nc<M) {
                    if(maze[nr][nc] == 1 && !visited[nr][nc]) {
                        q.add(new int[] {nr,nc,cnt+1});
                        visited[nr][nc] = true; 
                    }
                }
            }

        }


    }
}
 