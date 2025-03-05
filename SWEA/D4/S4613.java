import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4613 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        

        for(int t = 1; t<=T; t++) {

            String[] inputs = br.readLine().split(" ");
        
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            

            // 국기를 받아주기 위한 
            String[][] russiaFlag = new String[N][];
            for(int i = 0; i<N; i++) {
                russiaFlag[i] = br.readLine().split("");
            }

            
            for(int i = 0; i)
            
            
        } // tc loop
        


    }
}