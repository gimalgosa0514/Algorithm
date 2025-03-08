import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S6808 {
    
    static StringBuilder sb = new StringBuilder();
    static final int N = 9;
    static int winCnt;
    static int lossCnt;

    static int[] firstPlayer;
    static int[] secondPlayer;

    static boolean[] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
            

       
            winCnt = 0;
            lossCnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            firstPlayer = new int[N];
            secondPlayer = new int[N];
            visitied = new boolean[N];
            // firstPlayer 덱 초기화
            
            for(int i = 0; i<N; i++) {
                firstPlayer[i] = Integer.parseInt(st.nextToken());
            }

            // second 덱 초기화
            
            int idx = 0;
            loop1:for(int i = 1; i<=18; i++) {

                for(int j = 0; j<N; j++) {
                    if(firstPlayer[j] == i) {
                        continue loop1;      
                    }
                }

                secondPlayer[idx++] = i;
            }
            
            perm(0, 0, 0);

            
            sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(lossCnt).append("\n");


        } // tc loop

        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void perm(int round,int scoreA, int scoreB) {
        if(round == N) {
            if(scoreA > scoreB) {
                winCnt++;
            } else if(scoreB > scoreA) {
                lossCnt++;
            }
            return;
        }


        // 얘는 A의 카드 
        int idx = round;
        
        for(int i = 0; i<N; i++) {
            if(!visitied[i]) {

                visitied[i] = true;


                int newScoreA = scoreA;  // 원본 유지
                int newScoreB = scoreB;  // 원본 유지

                // A가 i번째 카드를 골랐다고해서 B가 i번째 카드를 못고르게 하면 안됨,
                if(firstPlayer[idx] > secondPlayer[i]) {

                    // 여기서 그냥 score써주면, 계속해서 값이 더렵혀지잖아.. 게망 게망아...
                    newScoreA += firstPlayer[idx] + secondPlayer[i];
                } else {
                    newScoreB += firstPlayer[idx] + secondPlayer[i];
                }
                perm(round+1, newScoreA, newScoreB);

                visitied[i] = false;
            }
            
            
        }
        

    }
 
}
