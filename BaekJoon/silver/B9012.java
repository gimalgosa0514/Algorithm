import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {
        

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int t = 0; t<T; t++) {
        
            // 괄호를 담을 스택 생성
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            // 괄호 짝이 맞는지를 판단할 flag.
            boolean isVPS = true;
            for(int i = 0; i<str.length(); i++) {

                char c = str.charAt(i);
                // 만약 c가 여는 괄호면 집어넣음.
                if(c == '(') {
                    stack.push(c);
                } else {
                    // 아니면 빼야하는데, 에초에 스택이 비어있다? 그럼 괄호짝이 안맞음. 그래서 끝냄.
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    // 스택이 차 있으면 정상적으로 뺌.
                    stack.pop();
                }
            }


            // 다 돌고 나왔을 때 스택이 비어있고, vps가 트루이면, 맞음. 아니면 아님.
            if(stack.isEmpty() && isVPS) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
}
