import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4613 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        

        for(int t = 1; t<=T; t++) {

            String[] inputs = br.readLine().split(" ");
        
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            

            // 국기를 받아주기 위한 
            String[][] russiaFlag = new String[N][];
            for(int i = 0; i<N; i++) {
                russiaFlag[i] = br.readLine().split("");
            }

            
            // 첫 출과 마지막줄을 흰, 빨로 주고, 그 사이의 파란색 값이 가장 적을수가 있도록?? 해보쟈.
            int minChange = Integer.MAX_VALUE;
            for(int start = 1; start<N-1; start++) {

                for(int end = start; end<N-1; end++) {
                    int changeCount = 0;
                    
                    // 흰색 변경
                    for(int i = 0; i<start; i++) {
                        for(int j = 0; j<M; j++) {
                            if(!russiaFlag[i][j].equals("W")) {
                                changeCount++;
                            }
                        }
                    }


                    // 블루 변경
                    for(int i = start; i<=end; i++) {
                        for(int j = 0; j<M; j++) {
                            if(!russiaFlag[i][j].equals("B")) {
                                changeCount++;
                            }
                        }
                    }

                    // 빨강 변경

                    for(int i = end+1; i<N; i++) {
                        for(int j = 0; j<M; j++) {
                            if(!russiaFlag[i][j].equals("R")) {
                                changeCount++;
                            }
                        }
                    }
                    
                    minChange = Math.min(minChange, changeCount);
                }

            }
            sb.append("#").append(t).append(" ").append(minChange).append("\n");

            }// tc loop
            
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            
    } 
        
       
}
