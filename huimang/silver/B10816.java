import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B10816 {
    public static void main(String[] args) throws IOException{
        
        Map<Integer, Integer> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 배열의 길이 N 
        int N = Integer.parseInt(br.readLine());
        
        // 배열의 값을 받아서 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];

        for(int i = 0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken(" "));
        }


        // 목표가 되는 배열의 길이 N
        int M = Integer.parseInt(br.readLine());

        // targets 받아서 초기화.
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) {
            targets[i] = Integer.parseInt(st.nextToken(" "));
        }


        for(int i = 0; i<cards.length; i++) {
            Integer count = map.get(cards[i]);
            if(count == null) {
                int cnt = 1;
                map.put(cards[i], cnt);
            } else {
                count++;
                map.put(cards[i], count);
            }
        }
        

        for(int i = 0; i<M; i++) {
            if(map.get(targets[i]) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(map.get(targets[i])).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

    }
}
