import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class S1216 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        
        for(int tc = 1; tc<=10; tc ++) {
            
            
            int t = Integer.parseInt(br.readLine().trim());
            
            int N = 100;

            char[][] charArr = new char[N][N];
            
            //우선 배열 초기화 먼저..
            for(int i = 0; i<N; i++) {
                charArr[i] = br.readLine().trim().toCharArray();                
            }



            // 횡우선, 열우선 탐색을 하면서, 회문을 찾고, 카운트를 늘려주면 됨.
            
            // 횡 우선 순회 먼저 ㄱㄱ
            // j 에서 n까지 회문이 되는 애를 찾고, 된다면, 길이가 몇인지를 판단하면 될듯?

            int max = -1;

            for(int i = 0; i<N; i++) {
                
                for(int j = 0; j<N; j++) {
                   
     
                    for(int k = j; k<N; k++) {

                        StringBuilder tempStr = new StringBuilder();
                        StringBuilder tempStr2 = new StringBuilder(); // 열 우선 순회.

                        // j 부터 k까지 즉 부분배열을 돌면서 회문이 있는지, 없는지 검사하는거임..
                        for(int q = j; q<=k; q++) {
                            tempStr.append(charArr[i][q]);
                            tempStr2.append(charArr[q][i]);
                        }
                        if(tempStr.toString().equals(tempStr.reverse().toString())) {
                            if(max < tempStr.toString().length()) {
                                max = tempStr.toString().length();
                            }
                        }
                        if(tempStr2.toString().equals(tempStr2.reverse().toString())) {
                            if(max < tempStr2.toString().length()) {
                                max = tempStr2.toString().length();
                            }
                        }
                    }
                    

                    
                }
            } // 


            sb.append("#" + t + " " + max + "\n");


        }


        bw.write(sb.toString().trim());
        bw.flush();


    }
}
