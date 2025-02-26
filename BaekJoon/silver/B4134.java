import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4134 {


    public static boolean isPrime(long n) {
        if(n == 2) return true;
        if(n%2 == 0) return false;

        for(long i = 3; i*i<=n; i+=2) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            long n = Long.parseLong(br.readLine());
            if(n < 0) {
                sb.append(2).append("\n");
            }
            while(!isPrime(n)) {
                if(n%2 == 0) {
                    n++;
                    continue;
                }
                n+=2;
            }
            sb.append(n).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
