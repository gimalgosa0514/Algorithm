import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 풀이 :
 * N의 사이즈가 커질수록 브루트 포스를 활용하기에는 너무 비효율적이기에 백트래킹을 이용해야한다.
 * 방문을 체크하기 위한 배열을 만들고, 상, 위쪽 대각선을 검사하며 갈 수 있으면 간다.
 * 단 돌아나와서 방문 배열을 원 상태로 돌려놓는 복구 작업이 필요하다.
 */
public class S2806 {
    
    
    static int N;
    
    // 상 , 상좌, 상우
    static int[] dr = {-1,-1,-1};
    static int[] dc = {0,-1,1};
    
    static int[][] maps;

    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
        
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        
        
        for(int t = 1; t<=T; t++) {

            N = Integer.parseInt(br.readLine());
            maps = new int[N][N];
            result = 0;
            nQueen(0);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
        

    }
    
    public static void nQueen(int row) {
        // N이 되면 탈출을 한 후 result를 증가시킨다. 
        if(row == N) {
                result++;
            return;
        }

        for(int c = 0; c<N; c++) {
            
            if(check(row, c)) {
                maps[row][c]++;
               
                nQueen(row+1);
                maps[row][c]--;
            }
            
        
        }
    
    }

    public static boolean check(int row, int col) {
        
        for(int amount = 0 ;amount <= row; amount++) {
            
            for(int i = 0; i<3; i++) {
                int nr = row + amount * dr[i];
                int nc = col + amount * dc[i];

                if(nr >= N || nr<0 || nc >= N || nc<0 ) {
                    continue;
                }

                // 있는거니깐 못가.
                if(maps[nr][nc] > 0) {
                    return false;
                }
            }
            
        }
        return true;

        
    }


    
}
