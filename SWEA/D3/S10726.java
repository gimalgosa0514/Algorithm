import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S10726 {
    public static void main(String[] args) throws IOException{
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {

            
            String[] inputs = br.readLine().split(" ");
             
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);

            String binary = Integer.toBinaryString(M);
           
            String result = "ON";

            // ㅅㅂ 왜인지 모르겠지만, 길이가 작으면 무조건 OFF래 ;;;; 
            if(binary.length() < N) {
                result = "OFF";          
            } else {
                for(int i = binary.length()-1; (i> binary.length()-1-N && i>=0); i--) {
                    if(binary.charAt(i) == '0') {
                        result = "OFF";
                        break;
                    }
                }
            }
            

 



            sb.append("#").append(t).append(" ").append(result).append("\n");
        } // tc

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }   
}