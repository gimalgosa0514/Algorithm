import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1213 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringBuilder sb = new StringBuilder();
        
        int t = 0;
        while(t != 10) {
            
            
            t = Integer.parseInt(br.readLine());

            String target = br.readLine();
            String source = br.readLine();

            int N = source.length();
            int M = target.length();


            // source에서 target이 몇번 등장할까? 카운트를 위해 선언함.
            int count = 0;

            // source의 길이까지 돌 필요가 없음. M의길이 전까지만 돌면 몽마인지알지?
            for(int i = 0; i<=N-M; i++) {

                // flag를 이용해서 count할지 말지.
                boolean flag = true;
                for(int j = 0; j<M; j++) {
                    
                    // 검사해주는데 i+j를 해줘야 해당 i번째에서 M의 길이만큼 갈 수 있는거임.
                    // 몽마인지 알지?
                    if(source.charAt(i+j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    count++;
                }

            }
            sb.append("#" + t + " " + count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}