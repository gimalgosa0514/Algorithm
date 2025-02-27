import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10779 {
    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 막대 개수를 담을 변수
        int barCnt = 0;
        
        // 조각 개수를 담을 변수
        int pieceCnt = 0;

        for(int i = 0; i<str.length(); i++) {
            
            char c = str.charAt(i);

            // c가 여는 괄호인데, 다음 괄호가 닫는 괄호이면 레이져.
            if(c == '(' && str.charAt(i+1) == ')') {
                //레이져이면 현재 막대기의 개수만큼 조각이 생김.
                pieceCnt += barCnt;
                // 그리고 다음 반복은 뛰어넘어야 하기에 
                i++;
            } else if(c == '(' && str.charAt(i+1) == '(') {
                //여는 괄호인데 다음 괄호가 여는 괄호다? 그럼 막대기 더 생김ㅎㅎ
                barCnt++;

                // 닫는 괄호이면 이미 레이져는 위에서 처리함.
            } else {
                //그럼 뭐다? 조각 하나 더 생기고 바 개수는 줄어드는거임.
                barCnt--;
                pieceCnt++;
            }

        }

        bw.write(String.valueOf(pieceCnt));
        bw.flush();
    }
}
