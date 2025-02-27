import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B10448 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

         // 일단 표현할 수 있는 범위까지 다 저장해보림
        int[] samgak = new int[44];
        for(int i = 1; i<=44; i++) {
            samgak[i-1] = i * (i + 1) / 2;
        }


        for(int t = 0; t<T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            
           
          
            boolean flag = false;
            //그리고 하나씩 찾아가면 끝!
            for(int i = 0; i<44; i++) {
                for(int j = 0; j<44; j++) {
                    for(int k = 0; k<44; k++) {
                        if(samgak[i] + samgak[j] + samgak[k] == N) {
                            flag = true;
                        }
                    }
                }
            } 

            if(flag) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
            

            

        }

        System.out.println(sb.toString());
    }
}
