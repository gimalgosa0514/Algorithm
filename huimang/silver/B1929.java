import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1929 {

    public static boolean isPrime(int n) {
        for(int i = 3; i*i<=n; i+=2) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for(int i = N; i<=M; i++) {
            // 짝수와 1은 소수가 아니니께 continue
            // 2는 소수니깐...
            if(i == 2) {
                sb.append(2).append("\n");
                continue;
            }
            if(i % 2 == 0 || i == 1) continue;
            
            if(isPrime(i)) {
                sb.append(i).append("\n");
            }
            


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }
}
