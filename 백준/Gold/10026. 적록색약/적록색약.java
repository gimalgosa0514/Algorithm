

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    static char[][] map;

    static int N;
    // 상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};


    static boolean[][] visitedFirst;
    static boolean[][] visitedSecond;

    static int firstResult;
    static int secondResult;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visitedFirst = new boolean[N][N];
        visitedSecond = new boolean[N][N];


        

        for(int i = 0; i<N; i++) {
            String input = br.readLine();
            for(int j = 0; j<input.length(); j++) {
                map[i][j] = input.charAt(j);
            }
        } // map 초기화

        
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(!visitedFirst[i][j]) {
                    bfsFirst(i, j);
                    firstResult++;
                }

                if(!visitedSecond[i][j]) {
                    bfsSecond(i, j);
                    secondResult++;
                }
            }
        }

        sb.append(firstResult).append(" ").append(secondResult);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        

    }


    // 적록색약 아닌 사람.
    static void bfsFirst(int r, int c) {
        Queue<int[]> q = new LinkedList<>();


        q.add(new int[] {r,c});
        visitedFirst[r][c] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int currY = curr[0];
            int currX = curr[1];
            
            char currColor = map[currY][currX];

            for(int i =0; i<4; i++) {
                
                int nr = currY + dr[i];
                int nc = currX + dc[i];

                if(nr < 0 || nr >=N || nc < 0 || nc >= N) continue;

                if(visitedFirst[nr][nc]) continue;

                if(currColor != map[nr][nc]) continue;

                q.add(new int[] {nr,nc});
                visitedFirst[nr][nc] = true;


            }

        }

    }


    // 적록 색약인 사람.
    static void bfsSecond(int r, int c) {


        Queue<int[]> q = new LinkedList<>();


        q.add(new int[] {r,c});
        visitedSecond[r][c] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int currY = curr[0];
            int currX = curr[1];
            
            char currColor = map[currY][currX];
        
            for(int i =0; i<4; i++) {
                
                int nr = currY + dr[i];
                int nc = currX + dc[i];

                if(nr < 0 || nr >=N || nc < 0 || nc >= N) continue;

                if(visitedSecond[nr][nc]) continue;

                if(currColor != 'B') {
                    if((currColor == 'R' || currColor =='G') && map[nr][nc] == 'B' ) continue; 
                } else {
                    if(map[nr][nc] == 'R' || map[nr][nc] == 'G') continue;
                }
                
                
                
                

                q.add(new int[] {nr,nc});
                visitedSecond[nr][nc] = true;

                

            }

        }

    }

}
