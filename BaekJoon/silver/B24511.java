import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class B24511 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();




        int N = Integer.parseInt(br.readLine());

        String[] dataStructures = br.readLine().split(" ");
        String[] originals = br.readLine().split(" ");


 
        Deque<Integer> q = new ArrayDeque<>();


        for(int i = 0; i<N; i++) {
            if(dataStructures[i].equals("0")) {
                q.offer(Integer.parseInt(originals[i]));
            } 
        }


        int M = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");


        for(String x : inputs) {
            q.offerFirst(Integer.parseInt(x));
           
            sb.append(q.pollLast()).append(" ");
        }

        
 

        bw.write(sb.toString());
        bw.flush();
        bw.close();



    }
}
