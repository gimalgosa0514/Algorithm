import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S1224 {
   
    
    public static void main(String[] args) throws IOException {
        
            StringBuilder result = new StringBuilder();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            

            for(int t=1; t<=10; t++) {


                //후위표기로 바꾼 결과물을 저장할 변수
                String prefix="";

                int N = Integer.parseInt(br.readLine());
                
                // 중위표현식
                String infix = br.readLine();


                // 연산자를 담을 스택
                Stack<Character> op = new Stack<>();
                for(int i = 0; i<N; i++) {
                    // 해당 위치의 문자열
                    char c = infix.charAt(i);

                    switch (c) {
                        case '+':
                        case '-':
                        case '/':
                        case '*':
                            // 연산자가 나오면 같은 규칙을 적용하는거임.
                            while(!op.isEmpty() && prioirty(c) <= prioirty(op.peek())) {
                                //비어있지 않고, 맨 위에 있는게 우선순위가 자기보다 높으면 다 꺼내주는거임
                                // 우선순위가 높거나 같은 애들을 빼주기 위해서.
                                prefix += op.pop(); 
                            }
                            //끝나면 걍 넣어줌
                            op.push(c);
                            break;
                        case '(':
                            // 여는 괄호다? 깡패놈임 걍 넣어.
                            op.push(c);
                            break;
                        case ')':
                            // 닫는 괄호다? 여는 괄호 만날 때 까지 다 토해버려~~~
                            while(!op.isEmpty() && op.peek() != '(') {
                                prefix += op.pop();
                            }
                            op.pop(); // 여는 괄호 만나면 걍 버림..
                            break;
                        default:
                            //그냥 숫자가 들어와버린다? 그럼 그냥 바로 써버려
                            prefix += c;
                            break;
                    }
                    

                } // infix -> to prefix loop
                //루프 끝났으면 이제 뱉어
                while(!op.isEmpty()) {
                    prefix += op.pop();
                } // prefix완성...
                

                //이제 계산하자... 수를 저장할 스택
                Stack<Integer> numStack = new Stack<>();
                
                // prefix길이만큼~ 돌자.
                for(int i = 0; i<prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    
                    //숫자야? 그럼 들어가.
                    if(c >= '0' && c<= '9') {
                        numStack.push(c-'0');
                    } else {
                        // 연산자야?
                        // 먼저 나오는애가 우측이다.. 일단 뽑아.
                        int B = numStack.pop();
                        int A = numStack.pop(); 

                        switch (c) {
                            case '+':
                                numStack.push(A+B);
                                break;
                            case '-':
                                numStack.push(A-B);
                                break;
                            case '/':
                                numStack.push(A/B);
                                break;
                            case '*':
                                numStack.push(A*B);
                                break;
                        }
                    }
                } // prefix 계산 loop

                result.append("#").append(t).append(" ").append(numStack.pop()).append("\n");



            }

            bw.write(result.toString().trim());
            bw.flush();


    }

    static int prioirty(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }


}
