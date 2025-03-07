import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        
        for(int amount = 0 ;amount < row; amount++) {
            
            for(int i = 0; i<3; i++) {
                int nr = row + amount * dr[i];
                int nc = col + amount * dc[i];

                if(nr >= N || nr<0 || nc >= N || nc<0 && maps[nr][nc] > 0) {
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
