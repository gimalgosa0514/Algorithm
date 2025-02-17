import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1225 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        for(int tc = 1; tc<=10; tc++) {
            int t = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
           
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int amount = 1;

            // 0인지 체크하는건데 걍 무겐루프 돌려도 될듯..
            while(queue.peek() != 0) {

                // 꺼내서 amount빼고 0인지 아닌지 체크하고 넣어주면 됨.
                int N = queue.remove();
                N = N - amount;
                amount++;

                // 0이면 탈출
                if(N <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(N);
               
                // amount가 6이면 5까지 루프 돈거니까 다시 1로.
                if(amount ==6) {
                    amount = 1;
                }
                
            }
            
            // 출력형식 만들어서
            sb.append("#").append(t).append(" ");
            for(Integer x : queue) {
                sb.append(x).append(" ");
            }
            sb.append("\n");



        }
        // 출력.
        bw.write(sb.toString());
        bw.flush();

    }
}
