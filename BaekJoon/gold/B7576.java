package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 { //일단은 BFS 없이 가보자.

    static int[][] arr;

    static int count = -1;

    //상 하 좌 우 순으로 배열 탐색
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    
    static Queue<int[]> q = new LinkedList<>();
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        arr = new int[N][M];


        // 배열 초기화
        for(int i = 0; i<N ;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.add(new int[] {i,j});
                }
            }
        }



        bfs();
        
        boolean flag = true;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(arr[i][j] == 0) {
                    flag = false; 
                    break;
                }
            }
            
        }
        if(flag) {
            bw.write(String.valueOf(count));
        } else {
            bw.write("-1");
        }
        
        bw.flush();

    }


    public static void bfs() {
        
        while(!q.isEmpty()) {
            int size = q.size(); // q의 길이가 변하니까..

            // 한 큐에 있는 사이즈 만큼만 돌아서 그 전날에만 들어온 토마토들 까지만 처리 해 줌.
            // 넣어놓으면 다음 날로 이동 하겠네.
            for(int j = 0; j<size; j++) {
                int[] position = q.poll();
                for(int i = 0; i<4; i++) {
                
                    int nr = position[0] + dr[i];
                    int nc = position[1] + dc[i];
    
    
                    //방문하지 않았다면.
                    
                    if(nr<N && nr >=0 && nc<M && nc >= 0) {
                        if(arr[nr][nc] == 0) {
                            arr[nr][nc] = 1;
                            q.add(new int[] {nr,nc});
                            
                        }
                        
                    }
                    
                }
            }
            count++;
        }
    }

}
