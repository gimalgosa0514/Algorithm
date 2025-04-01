package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1926 {

    static int[][] map;
    static boolean[][] visited;
    static int height;
    static int width;
    
    // 상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        visited = new boolean[height][width];


        for(int i = 0; i<height; i++) {
            String[] inputs = br.readLine().split(" ");

            for(int j = 0; j<width; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        } // 배열 초기화



        int count = 0;
        
        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width; j++) {

                if(!visited[i][j] && map[i][j] == 1) {
                    max = Math.max(max,dfs(i,j));
                    count++;
                }
            }
        }
        

        System.out.println(count);
        System.out.println(max);


    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        
        int area = 1;


        
        for(int i = 0; i<4; i++) {
            
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr>=height || nc<0 || nc>=width) continue;

            if(map[nr][nc] == 0) continue;

            if(visited[nr][nc]) continue;

            area += dfs(nr,nc);


        }

        return area;
    }
}
