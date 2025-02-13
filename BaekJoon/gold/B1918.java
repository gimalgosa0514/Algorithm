package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1918 {
    public static void main(String[] args) throws IOException{


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        // 1.일단은 문자열 길이만큼 반복 돌자.  
        
        for(int i = 0; i< str.length(); i++) {

            int rank = priority(str.charAt(i)); // 우선순위
            switch (str.charAt(i)) {
                case '+':
                case '-' :
                case '*':
                case '/' :
                    // 연산자 만났으면 이 규칙과 동일하게 적용
                    while(!stack.isEmpty() && priority(stack.peek()) >= rank) { // stack이 비어있지 않고, 제일 높은거의 우선순위가 p보다 크거나 같다?
                        // 그니까 우선순위가 크거나 같은 애들은 다 빼내주는거임.
                        sb.append(stack.pop()); // 안에있는거 다 빼줌.
                    }
                    stack.push(str.charAt(i)); // 이후 다시 넣어줌.
                    break;

                case '(':
                    stack.push(str.charAt(i));
                    break;

                case ')' :
                    // 괄호 안이 우선순위가 제일 높으니까, 에초에 괄호를 만나면, 괄호 안 연산자들 끼리는
                    // 우선순위 비교가 되는데, 괄호 밖에꺼는 아직도 괄호 밑에 깔려있음.
                    // 여는 괄호 만난다? 그럼 그냥 빼버림.
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); 
                    break;

                default:
                    sb.append(str.charAt(i)); // 알파벳은 걍 넣음 -> 피연산자.
                    break;
            }




        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();

    }

    
    static int priority(char c) {
        switch (c) {
                
            case '+':
                
                return 1;

            case '-':

                return 1;

            case '*':
                
                return 2;

            case '/':

                return 2;
            
            // 문자는 우선순위 0
            default:
                return 0;
        }
    }
}
