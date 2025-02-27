import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class B1620 {
    public static void main(String[] args) throws IOException {
    
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String[] NandM = br.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);

        // 숫자로 들어왔을때랑 문자로 들어왔을 때 두 경우를 처리하기 위해 map을 두개 만듬.
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();

        //넣어주고
        for(int i = 1; i<=N; i++) {
            String name = br.readLine();
            map.put(name, i);
            map2.put(i, name);
        }

        for(int i = 1; i<=M; i++) {
            
            String question = br.readLine();

            // 숫자인지 영어인지.
            if(Character.isAlphabetic(question.charAt(0))) {
                sb.append(map.get(question)).append("\n");
            } else {
                //숫자라면? 
                sb.append(map2.get(Integer.parseInt(question))).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    
    }
}