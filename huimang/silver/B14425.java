import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B14425 {
    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        
        
        String[] NandM = br.readLine().split(" ");
        
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);

        // 그냥.. 집합에 문자열 집어넣고..
        for(int i = 0; i<N; i++) {
            set.add(br.readLine().trim());
        }

        int count = 0;

        // 포함되어있는지 확인하고, 포함 되어있으면 count해주면 됨.
        for(int i = 0; i<M; i++) {
            if(set.contains(br.readLine().trim())) {
                count++;
            }
        }
        System.out.println(count);
    
    
    }




}
