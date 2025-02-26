import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4948 {    


    public static boolean isPrime(int n) {
        
        if(n == 1) {
            return false;
        }

        if(n ==2) {
            return true;
        } 

        if(n % 2 == 0) return false;

        for(int i = 3; i*i <=n; i+=2) {
            if(n % i == 0) return false;
        }

        return true;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n != 0) {
            int count = 0;
            
            for(int i = n+1; i<=n*2; i++) {
                if(isPrime(i)) {
                    count++;
                } 
            }

            sb.append(count).append("\n");


            n = Integer.parseInt(br.readLine());

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }
}
