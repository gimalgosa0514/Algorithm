package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10870 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(fib(N)));
        bw.flush();
    }

    public static int fib(int N) {

        // base : 종료 조건 = N이 0 또는 1일때!
        if(N == 1 || N == 0) {
            return N;
        }

        return fib(N-1) + fib(N-2);
    }
}
