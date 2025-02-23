import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1934 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = 0;
           if(a > b) {
                gcd = gcd(a,b);
           } else {
                gcd = gcd(b,a);
           }

           int lcm = a*b / gcd;

           sb.append(lcm).append("\n");
        }
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }

    // 유클리드 호제법을 이용한 최대공약수 구하기.
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b,a%b);
        }
    }

}