package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1918_RE {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<str.length(); i++) {

            char c = str.charAt(i);
            int rank = priority(c);

            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    
                    while(!stack.isEmpty() && priority(stack.peek()) >= rank) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() == '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
                    break;
            }


        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();

    }

    public static int priority(char c) {

        switch (c) {
            case '-':
            case '+':
                return 1;
            case '/':
            case '*':
                return 2;
            default:
                return 0;
        }
    }
}
