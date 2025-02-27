

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B27433 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Long N = Long.parseLong(br.readLine());
        bw.write(String.valueOf(factorial(N)));
        bw.flush();
        
    }

    static Long factorial(Long N) {

        //base : 반복 종료 조건 
        if(N == 1 || N == 0) {
            return 1L; 
        }

        return N * factorial(N-1);
    }
}
