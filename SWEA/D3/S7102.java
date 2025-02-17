import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class S7102 {
    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for(int t = 1; t<=T; t++) {

            String[] NandM = br.readLine().split(" ");
            
            int N = Integer.parseInt(NandM[0]);
            int M = Integer.parseInt(NandM[1]);

            int[] count = new int[N+M+1];
            for(int i = 1; i<=N; i++) {
                for(int j = 1; j<=M; j++) {
                    count[i+j]++;
                }
            }

            // 맥스 찾아서 값 넣는거였는데.. 생각해보니까 이렇게 까지 복잡하게 해야하나..? 
            // 이 부분 단축 필요.
            int max = -1;
            int maxIdx=0;
            for(int i = 1; i<count.length; i++) {
                if(count[i] > max) {
                    max =  count[i];
                    maxIdx = i;
                }
            }
            sb.append("#").append(t).append(" ").append(maxIdx).append(" ");
            for(int i = 0; i<count.length; i++) {
                if(count[i] == max && i != maxIdx) {
                    sb.append(i).append(" ");
                }
            }

            sb.append("\n");



        } // tc

        bw.write(sb.toString());
        bw.flush();

    } // main
}
