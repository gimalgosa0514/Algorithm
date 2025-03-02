import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B1010 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String N = st.nextToken();
            String M = st.nextToken();

            BigInteger ja = factorial(new BigInteger(M));
            BigInteger mo = factorial(new BigInteger(N)).multiply(factorial((new BigInteger(M).subtract(new BigInteger(N)))));
            sb.append(ja.divide(mo)).append("\n");
            
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static BigInteger factorial(BigInteger n) {
        if(n.intValue() == 1|| n.intValue() == 0) return new BigInteger("1"); 

        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
        
    }
}
