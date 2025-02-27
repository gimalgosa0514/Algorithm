import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class B7785 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            
           
            
            if(str[1].equals("leave")) {
                set.remove(str[0]);
                continue;
            }
            set.add(str[0]);
        }


        Object[] result = set.toArray();

        Arrays.sort(result, Collections.reverseOrder());

        for(int i = 0; i<result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        

        bw.write(sb.toString()); 
        bw.flush();
    }
}
