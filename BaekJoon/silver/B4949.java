package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        String line = br.readLine();
        while(!line.equals(".")) {
            
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for(int i = 0; i<line.length(); i++) {
                char c = line.charAt(i);
                if(c == '(' || c == '[')  {
                    s.push(c);
                }
                if(c == ')' && s.isEmpty() || c == ')' && s.pop()!= '(' ) {
                    flag = false;
                    break;
                }
                if(c == ']' && s.isEmpty() || c == ']' && s.pop()  != '[') {
                    flag = false;
                    break;
                }
                
            }
            if(flag && s.isEmpty()) {
                sb.append("yes").append("\n");
            } else if(!flag || !s.isEmpty()) {
                sb.append("no").append("\n");
            }

            line = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
