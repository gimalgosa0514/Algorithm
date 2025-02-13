import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class S5432 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {

        
            String str = br.readLine();
            

            // 바의 수는 ()가 아닌 (로 시작하는 애들으 ㅣ수임.
            int barCnt = 0;
            // 조각의 수는 레이저를 만날 때 마다 현재 바의 수를 더한거임. 문제 그림 보면 이해 쌉가능.
            int pieceCnt = 0;

            
            for(int i = 0; i<str.length(); i++) {
                char c = str.charAt(i);


                //바로 뒤에 나오는건 레이저니깐. 그리고 i+1 해서 문자열 길이 벗어나는 일 적어도
                // 이 문제에서는 없음.
                if(c == '(' && str.charAt(i+1) != ')') {
                   //(인데 바로 뒤에 )가 따라나오는게 아니니까 막대기 개수 증가.
                    barCnt++;
                    // (인데 바로 뒤에 )? 이거 레이저임. 현재 바의 수만큼 조각이 더해짐.
                } else if(c == '(' && str.charAt(i+1) == ')') {
                    pieceCnt += barCnt;

                    // 그리고 그 다음을 뛰어넘기 위해서 i에 1을 더해줌.
                    i++;
                } else {
                    // 만약 )가 왔다? 이건 그 막대기가 끝나는 시점임.
                    // 근데 레이저를 만났을 것이니 조각을 하나 더해주고, 막대기 수는 이제 
                    // 끝났으니 줄여줌.
                    pieceCnt++;
                    barCnt--;
                }


            }

            
            sb.append("#").append(t).append(" ").append(pieceCnt).append("\n");


        }
        bw.write(sb.toString());
        bw.flush();

    }
}
