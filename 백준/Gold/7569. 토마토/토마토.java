

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] tomato;
    static int M;
    static int N;
    static int H;
    static int result;

    // 상하좌우위아래
    static int[] dn = {-1,1,0,0,0,0};
    static int[] dm = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};

    // 큐
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer inputs = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(inputs.nextToken());
        N = Integer.parseInt(inputs.nextToken());
        H = Integer.parseInt(inputs.nextToken());

        tomato = new int[H][N][M];

        for(int k = 0; k<H; k++) {
            for(int i=0; i<N;i++) {
                inputs = new StringTokenizer(br.readLine());
                for(int j = 0; j<M; j++) {
                    tomato[k][i][j] = Integer.parseInt(inputs.nextToken());
                    if(tomato[k][i][j] == 1) {
                        q.add(new int[] {k,i,j,0}); // 익는 날짜도 같이 넣어줘야함.
                    }
                }
            }
        }

   
        
        
        bfs();

        boolean flag = true;
        loop1:for(int k= 0; k<H; k++) {
            for(int i= 0; i<N; i++) {
                for(int j = 0; j<M; j++) {
                    if(tomato[k][i][j] == 0) {
                        flag = false;
                        break loop1;
                    }
                }
                
            }
        }

        if(!flag) {
            result = -1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

        
    }


    public static void bfs() {

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int 높이 = curr[0];
            int 세로 = curr[1];
            int 가로 = curr[2];
            int day = curr[3];

            for(int i = 0; i<6; i++) {
                int 새높이 = 높이+dh[i];
                int 새세로 = 세로+dn[i];
                int 새가로 = 가로+dm[i];
                
                // 일단 안나가는 범위임.
                if(새높이 >=0 && 새높이<H && 새세로 >= 0 && 새세로 <N && 새가로 >=0 && 새가로 <M) {
                    if(tomato[새높이][새세로][새가로] == 0) {
                        tomato[새높이][새세로][새가로] = 1;
                        q.add(new int[] {새높이,새세로,새가로,day+1});
                    }
                }
            }
            result = day;
        }

        

    }

}
