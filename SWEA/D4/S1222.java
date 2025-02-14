import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S1222 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        for(int t = 1; t<=10; t++) {

            int strLenght = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
    
            String str = br.readLine();
    
            for(int i = 0; i<strLenght; i++) {
                char c =  str.charAt(i);
                if(c >= '0' && c<='9') {
                    sb.append(c);
                } else {
                    if(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
    
            }
    
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            
    
            Stack<Integer> numStack = new Stack<>();
            String prefix = sb.toString();
            
            for(int i = 0; i< strLenght; i++) {
                char c = prefix.charAt(i);
                // 숫자라면?
                if(c >= '0' && c<= '9') {
                    numStack.push(c-'0');
                } 
    
                else {
                    // 덧셈이라 딱히 순서가 중요하지는 않음.
                    numStack.push(numStack.pop() + numStack.pop());
                }
            }

            result.append("#").append(t).append(" ").append(numStack.pop()).append("\n");

        }
        

        bw.write(result.toString().trim());
        bw.flush();
    }



    

}
