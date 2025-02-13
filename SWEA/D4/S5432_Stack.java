import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S5432_Stack {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=T; t++) {
            
            Stack<Character> stack = new Stack<>();

            String str = br.readLine();
            int sum = 0;
            for(int i = 0; i<str.length(); i++) {
                char c = str.charAt(i);

                
                if(c == '(') {
                    stack.push(c);
                } else {
                    //레이져.
                    if(str.charAt(i-1) == '(') {
                        // 레이져용 빼면 남은건 막대기 수.
                        stack.pop();
                        sum += stack.size();
                    } else {
                        // 막대기 수 하나 줄이고 sum++;
                        stack.pop();
                        sum++;
                    }
                }

            }
            
            sb.append("#").append(t).append(" ").append(sum).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        

    }
}
