import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4134 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());


        for(int t = 0; t < T; t++) {
            

            Long n = Long.parseLong(br.readLine());
            
            while(true) {
                boolean flag = false;

                for(int i = 2; i<=n-1; i++) {
                    if(n%i == 0) { // i로 나누어 떨어지면? 
                        flag = true;
                        n++;
                        break;
                    }
                }

                // 참이면 탈출
                if(!flag) {
                    sb.append(n).append("\n");
                    break;
                }
            }
          



        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


    public static boolean isPrime(int n) {
        if(n==2) return true;
        if(n < 2 || n % 2 == 0) return false;  

        for(long i = 3; i*i <=n ; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
        

    }

}