import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class S1228 {
    public static void main(String[] args) throws IOException{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        for(int t = 1; t<=10; t++) {


            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이를 받음.

            String[] originalPassword = br.readLine().split(" ");


            // 여기다가 값 집어넣어야하니까롱..
            List<String> originalPasswordList = new ArrayList<>();

            for(int i = 0; i<N; i++) {
                originalPasswordList.add(originalPassword[i]);
            }
            
            int commandCnt = Integer.parseInt(br.readLine());

            String[] commands = br.readLine().replaceFirst("I","").split("I");
            

            // 불필요한 문자열들 지움.
            for(int i = 0; i<commandCnt; i++) {
                commands[i]= commands[i].trim();
            }

            // 커맨드대로 명령을 수행.
            for(int i = 0; i<commandCnt; i++) {
                String[] command = commands[i].split(" ");

                int x = Integer.parseInt(command[0]);
                int y = Integer.parseInt(command[1]);
                for(int j = 0; j<y; j++) {
                    originalPasswordList.add(x++, command[j+2]);
                }                

            }


            // 명령 끝난 후 10자리 넣어서 출력.
            sb.append("#").append(t).append(" ");

            for(int i = 0; i<10; i++) {
                sb.append(originalPasswordList.get(i)).append(" ");
            }
        
            sb.append("\n");
           




        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
