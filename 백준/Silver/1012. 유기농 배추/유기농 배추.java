

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int width;
    static int height;

    // 상 하 좌 우 
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};



    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            

            map = new int[height][width];
            visited = new boolean[height][width];

            for(int i = 0; i<K; i++) {
                st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = 1;

            }

        
            int result = 0;
            for(int i = 0; i<height; i++) {
                for(int j = 0; j<width; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        result++;
                    }
                }
            }

            sb.append(result).append(" ").append("\n");


        } // tc loop
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for(int i =0; i<4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            if(nr<0 || nr>=height || nc<0 || nc>=width) continue;

            if(map[nr][nc] == 0) continue;

            if(visited[nr][nc]) continue;
            
            dfs(nr,nc);
            
            

        }
    }


}
