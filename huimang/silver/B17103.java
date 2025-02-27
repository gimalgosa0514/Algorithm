import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B17103 {





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = isNotPrime[1] = true;

        for(int i = 2; i*i <= 1000000; i++) {
            if(!isNotPrime[i]) {
                for(int j = i*i; j <= 1000000; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for(int t = 0; t<T; t++) {
            int even = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i = 2; i<=even / 2; i++) {
                if(!isNotPrime[i]) {
                    if(!isNotPrime[even-i]) {
                        count++;
                    }
                }
            }
            int result = count;
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
