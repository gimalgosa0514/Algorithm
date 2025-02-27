import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class B10815 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        Map<Integer,Integer> map = new HashMap<>();



        int N = Integer.parseInt(br.readLine());
        String[] strN = br.readLine().split(" ");       
        
        // 맵에 카드 값을 키로 하여금 넣어둠.
        for(int i = 0; i < N; i++) {
            map.put(Integer.parseInt(strN[i]), 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] strM = br.readLine().split(" ");
        
        
        for(int i = 0; i< M ; i ++) {
        // 찾을 때 맵 안에 해당 숫자로 된 키값이 있냥 없냥만 체크하면 끝~
            if(map.containsKey(Integer.parseInt(strM[i]))) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

    }
}
