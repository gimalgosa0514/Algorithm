import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1935 {
    // 이 문제에서 가장 중요한건.. 스택이고, 뭐 ABC순서고 뭐고 내 생각엔 2자리수가 넘어가는 정수를
    // 어뜨케 처리할 것인지가 아닐까...
    // 그리고 후위수식을 계산하는 방법. -> 23+ 가 있다면 문자열 순서대로 스택에 넣는데, 숫자면 그냥 넣어주고, 문자 즉 연산자이다? 그럼 스택에 있는 수를 두 개 꺼냄.
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        
        Stack<String> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());


        //우선은 후위표기식으로 알파벳 상태로 들어 왔을 때 끊어줘야함.
        String[] str = br.readLine().split("");

        
        
        // N 크기 만큼의 배열을 만들어 주고.
        int[] num = new int[N];
        
        // 먼저 숫자를 받아주고, 문자열로 바꿔줘야함. 안그러면 BA인 경우 첫번째 수가 B에 들어가게됨 ㅠ
        for(int i = 0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }


        // A부터시작이니까.
        char character = 'A';
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<str.length; j++) {
                
                // 첫번째 루프. str[j]번째가 A인지 A라면 우리가 처음 입력해준 수로 변경. 이렇게 쭉 쭉 나아가는거임.
                if(str[j].charAt(0) == character) {
                    str[j] = String.valueOf(num[i]);
                }
            }
            // 값을 바꿔줘야하니깐.
            character++;
        }


        //이제 문자열 길이만큼 돌꺼임.
        for(int i = 0; i<str.length; i++) {

            // 처음에 문자열 하나를 가져옴. 이때 만약 숫자가 두자리 수인데, 문자로 받아왔다고 생각해보셈, 애초에 짤리긴 하노.
            String c = str[i];

            //가져온게, 연산자다? 하면 연산자에 맞게 처리를 해줄꺼임.
            if(c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
                
                // 각 연산의 과정을 스택에 넣어야함. 그걸 위한 변수.
                double result = 0;

                // 이때 먼저 꺼낸게, 연산자 기준 우측에 위치하게됨. (후위표기식에서 뭐 다른 곳은 어떨지는 잘...)
                double n2 = Double.parseDouble(stack.pop());

                // 그 다음 수를 꺼내줌.
                double n1 = Double.parseDouble(stack.pop());

                char operator = c.charAt(0);
                

                // 연산자에 맞게 계산.
                switch (operator) {
                    case '+':
                        result += n1+n2;
                        stack.push(String.valueOf(result));
                        break;
                
                    case '-':
                        result += n1-n2;
                        stack.push(String.valueOf(result));
                        break;
            
                    case '*':
                        result += n1*n2;
                        stack.push(String.valueOf(result));
                    break;
            
                    case '/':
                        result += n1/n2;
                        stack.push(String.valueOf(result));
                    break;
                }


            } else {
                
                // 근데 연산자가 아니면 숫자니까, 스택에 넣어줌.
                stack.push(c);
                
            
            }
        
        }

        
        bw.write(String.format("%.2f", Double.parseDouble(stack.pop())));
        bw.flush();



    }


}



