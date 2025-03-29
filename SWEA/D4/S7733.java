package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class S7733 {

    // 상, 하, 좌, 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    
    static int[][] cheese;
    static int N;
    static boolean[][] visited;

    static int loaf;
    static int max;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int t = 1; t<=T; t++) {

            N = Integer.parseInt(br.readLine());
            
            cheese = new int[N][N];
            max = -1; // 덩어리 수 중 최고.
            int zeroCnt = 0;
            for(int i = 0; i<N; i++) {
                String[] inputs = br.readLine().split(" ");
                for(int j = 0; j<N; j++) {
                    cheese[i][j] = Integer.parseInt(inputs[j]);
                }
            } // cheese 초기화
            
            for(int day = 1; day<=100; day++) {
                //여기서 부터 갉아 먹을꺼임
                visited = new boolean[N][N];
                loaf = 0;
                for(int i = 0; i<N; i++) {
                    for(int j = 0; j<N; j++) {
                        if(cheese[i][j] == day) {
                            cheese[i][j] = 0;
                            zeroCnt++;
                        }
                    }
                } // 치즈 갉아먹기.

                // 치즈 다 갉아 먹었으면 그만 돌아.
                if(zeroCnt == N*N) {
                    break;
                }

                //갉아먹고 난 후 bfs돌려서 덩어리 수 갱신하기.
                for(int i = 0; i<N; i++) {
                    for(int j = 0; j<N; j++) {
                        if(cheese[i][j] != 0) {
                            if(!visited[i][j]) {
                                bfs(i,j);
                            }
                            
                        }
                    }
                }

            } // 날짜.
            
            if(max == -1) {
                max = 1;
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");

        } // tc Loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {r,c});
        visited[r][c] = true;
        // 0이 아닌애들은 모두 큐에 담긴상태임.
        while(!q.isEmpty()) {


            // 큐에서 요소를 꺼내고, 
            int[] curr = q.poll();
            
            int currR = curr[0];
            int currC = curr[1];
            
            for(int i = 0; i<4; i++) {
            
                int nr = currR + dr[i];
                int nc = currC + dc[i];
                
                // 일단 치즈 범위 내이면서, 해당 부위가 0이 아니다? 그럼 방문처리.
                if(nr >= 0 && nr<N && nc>= 0 && nc<N && cheese[nr][nc] != 0 && !visited[nr][nc]) {
                    q.add(new int[] {nr,nc});
                    visited[nr][nc] = true;
                    
                }
            }
        }
        loaf++;
        max = Math.max(max, loaf);


    }


}
