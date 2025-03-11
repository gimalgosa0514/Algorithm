package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int diff;
    static List<Integer> result = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        // map 초기화
        for(int i= 0; i<N; i++) {
            String[] inputs = br.readLine().split("");
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        
        bfs();

        
        StringBuilder sb = new StringBuilder(String.valueOf(diff));
        sb.append("\n");
        Collections.sort(result);
        for(int n : result) {
            sb.append(n).append("\n");
        }
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                // i,j가 1을 만났는데, 방문하지 않았다? 여기서부터 돌자.
                if(map[i][j] == 1 && !visited[i][j]) {
                    diff++;
                    int startY = i;
                    int startX = j;
                    
                    int resultNum = 1;
                    q.add(new int[] {startY, startX});
                    

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        int currY = curr[0];
                        int currX = curr[1];
                        visited[currY][currX] = true;

                        for(int k = 0; k<4; k++) {
                            int nr = currY + dr[k];
                            int nc = currX + dc[k];
                            
                            if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] == 1 && !visited[nr][nc]) {
                                resultNum++;
                                visited[nr][nc] = true;
                                q.add(new int[] {nr,nc});
                            }
                        }
                        
                    }
                    result.add(resultNum);
                }
            }
        }
        
    }
    
}
