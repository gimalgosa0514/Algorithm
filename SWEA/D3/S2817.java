import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2817 {

    
    static boolean[] flag;

    static int[] numbers; 
    static int count;
    static int K;
    static int N; 
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            String[] inputs = br.readLine().split(" ");
            
            N = Integer.parseInt(inputs[0]);
            K = Integer.parseInt(inputs[1]);
            flag = new boolean[N];
            numbers = new int[N];
            count = 0;
            String[] str = br.readLine().split(" ");

            // numbers 초기화.
            for(int i = 0; i<str.length; i++) {
                numbers[i] = Integer.parseInt(str[i]);
            }

            count(0);

            sb.append("#").append(t).append(" ").append(count).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void count(int idx) {
        
        
        // 종료
        if(idx == N) {
            int sum = 0;
            for(int i = 0; i<flag.length; i++) {
                if(flag[i]) {
                    sum += numbers[i];
                }

            }
            if(sum == K) {
                count++;
            }
            return;
        }
        // 재귀
        
        flag[idx] = true;
        count(idx+1);

        flag[idx] = false;
        count(idx+1);

    }
}
