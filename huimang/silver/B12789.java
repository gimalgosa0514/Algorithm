

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        String[] str = br.readLine().split(" ");
        
        int curr = 1;
        for(int i = 0; i<N; i++) {
            int n = Integer.parseInt(str[i]);
            if(curr != n) {
                if(!s.isEmpty()&& s.peek() == curr) {
                    s.pop();
                    i--;
                    curr++;
                } else {
                    s.push(n);
                }
            } else {
                curr++;
            }
        }
        
        while(!s.isEmpty()) {
            int n = s.pop();
            if(n == curr) {
                curr++;
            } else {
                bw.write("Sad");
                bw.flush();
                System.exit(0);
            }
        }
        bw.write("Nice");
        bw.flush();


    }
}
