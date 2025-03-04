import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5215 {


    static int[] kcal;
    static int[] gradient;
    static boolean[] sel;

    static int max;
    static int L; 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=T; t++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            max = Integer.MIN_VALUE;
            kcal = new int[N];
            gradient = new int[N];
            sel = new boolean[N];
            

            //kcal이랑 gradient 초기화
            for(int i = 0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                gradient[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());                
            }


            cal(0);

            sb.append("#").append(t).append(" ").append(max).append("\n");


        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void cal(int idx) {
        if(idx == gradient.length) {
            int tempScore = 0;
            int tempKcal = 0;
            for(int i = 0; i<idx; i++) {
                if(sel[i]) {
                    tempScore += gradient[i];
                    tempKcal += kcal[i];
                }
            }

            if(tempKcal <= L) {
                max = Math.max(max, tempScore);
            }
            return; 
        }

        sel[idx] = false;
        cal(idx+1);

        sel[idx] = true;
        cal(idx+1);

    }
    
}