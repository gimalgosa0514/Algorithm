import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10820 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 첫 줄 읽어들임.
        String str = br.readLine();

        // 문자열이 null이 아닐 때 까지 반복하겠다! 
        while(str != null) {
            
            //문자 배열로 만들어 주고.
            char[] charArr = str.toCharArray();
            

            // 결과를 담을 각각의 변수들 
            int large = 0;
            int small = 0;
            int number = 0;
            int space = 0;
            

            // 조건을 걸어줌.
            for(int i = 0; i<charArr.length; i++) {
                if(charArr[i] >='A' && charArr[i] <='Z') {
                    large++;
                } else if(charArr[i] >= 'a' && charArr[i] <='z') {
                    small++;
                } else if(charArr[i]>='0' && charArr[i] <='9') {
                    number++;
                } else {
                    space++;
                }
            }

            // 결과 넣고
            sb.append(small).append(" ").append(large).append(" ").append(number)
            .append(" ").append(space).append("\n");

            // 다음 줄 읽음 얘에 더이상 입력을 안받으면 끝.
            str = br.readLine();
        }

        // 출력
        bw.write(sb.toString().trim());
        bw.flush();
    }
}