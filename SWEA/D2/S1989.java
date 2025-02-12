import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1989 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {

            String str = br.readLine().trim();
            StringBuilder reverseStr = new StringBuilder(str);
            if(str.equals(reverseStr.reverse().toString())) {
                sb.append("#").append(t).append(" ").append(1).append("\n");
            } else {
                sb.append("#").append(t).append(" ").append(0).append("\n");
            }
        }
        

        bw.write(sb.toString());
        bw.flush();


    }
}
