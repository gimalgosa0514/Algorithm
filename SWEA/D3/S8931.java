import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S8931 {
    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        

        int tc = Integer.parseInt(br.readLine().trim());

        for(int t = 1; t<=tc; t++) {

            Stack<Integer> stack = new Stack<>();
            int K = Integer.parseInt(br.readLine().trim());
            
            for(int i = 0; i<K; i++) {

                int num = Integer.parseInt(br.readLine().trim());
                if(num == 0) {
                    stack.pop();
                } else {
                    stack.push(num);
                }

            }

            int ans = 0;
            for(Integer n : stack) {
                ans += n;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        
        }
        
        bw.write(sb.toString().trim());
        bw.flush();

    }

}