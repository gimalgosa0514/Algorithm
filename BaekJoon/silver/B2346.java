import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B2346 {
    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        

        int N = Integer.parseInt(br.readLine());
        
        Deque<List<Integer>> q = new ArrayDeque<>();
        
        String[] inputs = br.readLine().split(" ");

        for(int i = 0; i<N; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(i+1);
            a.add(Integer.parseInt(inputs[i]));
            q.add(a);
        }


        int idx = 0 ;
        while(true) {
            List<Integer> balloon = q.removeFirst();
            int move = balloon.get(1);
            sb.append(balloon.get(0)).append(" ");
            if(q.isEmpty()) {
                break;
            }
            if(move > 0) {
                for(int j = 0; j<move-1; j++) {
                    q.addLast(q.removeFirst());
                }
            } else if(move < 0) {
                
                for(int j = 0; j<Math.abs(move)-1; j++) {
                    q.addFirst(q.removeLast());
                }
                
            }


        }

        while(!q.isEmpty()) {
            sb.append(q.removeFirst().get(0)).append(" ");
        }


        bw.write(sb.toString());
        bw.flush();
    }
}
