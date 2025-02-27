import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class B11866 {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        sb.append("<");
        
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        
        
        List<Integer> list = new LinkedList<>();
        
        for(int i = 1; i<=N; i++) {
            list.add(i);
        }


        // 삭제 시 인덱스가 중요함.
        int idx = 0;
        while(list.size()!=0) {

            // index에서 부터 K-1번째 사람을 죽여야 하는데, 이때 범위를 벗어나는것을 방지하기 위해서
            
            idx = (idx+K-1) % N;
            if(list.size() != 1) {
                sb.append(list.remove(idx)).append(", ");
            } else {
                sb.append(list.remove(idx));
            }
            

            // 길이가 점점 줄어드니까.. N도 줄어듦..
            N--;
        }

        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
    }

    
}
