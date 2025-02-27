package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B23250 {
    static long K;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String[] str = br.readLine().trim().split(" ");
        
        int N = Integer.parseInt(str[0]);
        K = Long.parseLong(str[1]);
        hanoi(N, "1", "3", "2");
    }



    public static void hanoi(int N, String from, String to, String temp) throws IOException {


        // base : 종료 조건, 만약 N이 1이다? 그럼 from 에서 to로 이동해야지~ 
        if(N == 1) {
            K--;
            if(K == 0) {
                bw.write(from + " " + to);
                bw.flush();
                System.exit(0);
            }
            return; 
        } 

        hanoi(N-1, from, temp, to);
        K--;
        if(K == 0) {
            bw.write(from + " " + to);
            bw.flush();
            System.exit(0);
        }
        hanoi(N-1, temp, to, from);
        return;


    }

}
