import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class B1259 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 첫 줄 읽고
        String str = br.readLine().trim();
        // 문자열이 0이 들어올 때 까지 반복.
        while(!str.equals("0")) {

            // 배열로 바꿔주고
            char[] charArr = str.toCharArray();
            
            // flag 세워서 회문 여부 판단.
            boolean flag = true;
            
            //  양쪽 끝에서부터 중앙까지 반복.
            for(int i = 0; i<charArr.length/2; i++) {

                // 양쪽 문자열이 다르다? 그럼 회문 아니지~ 그래서 플래그 바꾸고 끝
                if(charArr[i] !=  charArr[charArr.length-1-i]) {
                    flag = false;
                    break;
                }
            }


            // 회문이면 yes, 아니면 no
            if(flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

            // 다음 입력 읽음.
            str = br.readLine();
        }
        
        // 출력.
        bw.write(sb.toString());
        bw.flush();
    }
}
