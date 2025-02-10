import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B18870 {
    
    public static void main(String[] args) throws IOException{
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int z = 0;
        while(st.hasMoreTokens()) {
            arr[z++] = Integer.parseInt(st.nextToken(" "));
        }

        int[] original = Arrays.copyOf(arr,N);


        Arrays.parallelSort(arr);
        
        
        int idx = 0;
        for(int i = 0; i<arr.length; i++) {
            Integer num  = map.get(arr[i]);
            if(num == null) {
                map.put(arr[i], idx++);
            }
        }

        for(int i = 0; i<original.length; i++) {
            sb.append(map.get(original[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        
        

    }
}
