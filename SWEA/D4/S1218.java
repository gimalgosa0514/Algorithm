import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1218 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        set.add('<');

        for(int t = 1; t<=10; t++) {

            Stack<Character> stack = new Stack<>();

            int strLenght = Integer.parseInt(br.readLine());
            String str = br.readLine();
            boolean flag = true;
            out:for(int i = 0; i<strLenght; i++) {
                
                // 1. 일단 문자열을 읽어들인 후 괄호를 판단
                char c = str.charAt(i);

                // 셋에 있는 괄호이다? -> 닫힌 괄호이다.
                if(set.contains(c)) {
                    // 스택에 넣음.
                    stack.push(c);
                } else {
                    // 셋에 없다? 마지막 괄호랑 꺼내서 비교 -> 안똑같아? 그럼 안뇽~
                    char inStack = stack.pop();
                    switch(c) {
                        case ')':
                            if(inStack != '(') {
                                flag = false;
                                break out;
                            }
                            break;
                        case '}' :
                            if(inStack != '{') {
                                flag = false;
                                break out;
                            }
                            break;
                        case ']' :
                            if(inStack != '[') {
                                flag = false;
                                break out;
                            }
                            break;
                        case '>' :
                            if(inStack != '<') {
                                flag = false;
                                break out;
                            }
                            break;
                    }
                }


            }

            if(flag) {
                sb.append("#").append(t).append(" ").append(1).append("\n");
            } else {
                sb.append("#").append(t).append(" ").append(0).append("\n");
            }

        }

        bw.write(sb.toString());
        bw.flush();


    }
}
