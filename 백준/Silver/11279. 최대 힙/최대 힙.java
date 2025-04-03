import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2-o1;
            }
            
        });
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            int command = Integer.parseInt(br.readLine());


            switch (command) {
                case 0:
                    if(pq.isEmpty()) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(pq.poll()).append("\n");
                    }
                    break;
            
                default:
                    pq.add(command);
                    break;
            }

        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        


    }
}
