import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    static int N;

  

    static boolean[][] visited;
    // 상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
    
        int max = -1;
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        } // 맵 초기화

        

        int result = 0;

        for(int rate = 0; rate<=max; rate++) {
            visited = new boolean[N][N];
            int tmp = 0;
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    if(map[i][j] <=rate) {
                        map[i][j] = -1; 
                    }
                }

            } // 강수량 만큼 잠궈버림. 새 배열은 안만들어도 됨 어차피 강수량은 증가하니까.

            for(int i =0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] != -1) {
                        bfs(i,j); 
                        tmp++;
                        // 강수량 마다 bfs가 도는 횟수를 체크하고 
                        // 그 중 맥스값을 찾으면 정답임.
                    }
                }
            } // 잠그고 나서 bfs 돌아버림.
            result = Math.max(tmp, result);
            
        }


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    
    }


    public static void bfs(int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});
        visited[r][c] = true;


        while(!q.isEmpty()) {

            int[] currNode = q.poll();
            int currR = currNode[0];
            int currC = currNode[1];


            for(int i = 0; i<4; i++) {

                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if(nr <0 || nr>=N || nc<0 || nc>=N) continue;

                if(map[nr][nc] <1) continue;

                if(visited[nr][nc]) continue;

                q.add(new int[] {nr,nc});

                visited[nr][nc] = true;

            }

        }


    }

}