import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S1230 {
    public static void main(String[] args) throws IOException{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        for(int t = 1; t<=10; t++) {


            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이를 받음.

            String[] originalPassword = br.readLine().split(" ");


            // 여기다가 값 집어넣어야하니까롱..
            List<String> originalPasswordList = new LinkedList<>();

            for(int i = 0; i<N; i++) {
                originalPasswordList.add(originalPassword[i]);
            }
            
            int commandCnt = Integer.parseInt(br.readLine());

            Queue<String> commandQueue = new LinkedList<>();

            String[] commands = br.readLine().split(" ");
            
            for(int i = 0; i < commands.length; i++) {
                commandQueue.add(commands[i]);
            }

            while(commandQueue.peek() != null) {
                String command = commandQueue.poll();
                
                switch (command) {
                    case "I":
                        //삽입일 때 .      
                            int x = Integer.parseInt(commandQueue.poll());
                            int y = Integer.parseInt(commandQueue.poll());
                            for(int i = 0; i<y; i++) {
                                originalPasswordList.add(x++,commandQueue.poll());
                            }
                            break;
                    case "D":
                            x = Integer.parseInt(commandQueue.poll());
                            y = Integer.parseInt(commandQueue.poll());
                            for(int i = 0; i<y; i++) {
                                originalPasswordList.remove(x++);
                            }
                        break;
                    case "A":
                            y = Integer.parseInt(commandQueue.poll());
                            for(int i = 0; i<y; i++) {
                                originalPasswordList.add(commandQueue.poll());
                            }
                        break;
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
