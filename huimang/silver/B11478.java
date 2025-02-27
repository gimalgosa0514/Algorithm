import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B11478 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();

        List<String> list = new ArrayList<>();


        //모든 문자열의 부분을 탐색하는 코드임...
        for(int i = 0; i<str.length(); i++) {
            // 어찌보면 당연한거같기도 하고..? 
            for(int j = 1+i; j <= str.length(); j++) {
                list.add(str.substring(i, j));
            }
        }
        
        bw.write(String.valueOf(list.size()));
        bw.flush();
       
    }
}
