import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2001 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        



        // 테스트 케이스
        int tc = Integer.parseInt(br.readLine());


        for(int t = 1; t<=tc; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 배열의 크기.
            int N = Integer.parseInt(st.nextToken(" "));
            
            // 파리채의 크기
            int M = Integer.parseInt(st.nextToken(" "));

            // 배열의 크기만큼 배열 만들고
            int[][] arr = new int[N][N];

            // 배열 값 초기화.
            for(int i =0; i<N; i++) {
                StringTokenizer values = new StringTokenizer(br.readLine());
                
                for(int j = 0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(values.nextToken(" "));
                }
            }

            // 정답값. 
            int max = 0;

            for(int i = 0; i<N; i++) {

               

                for(int j = 0; j<N; j++) {
                    
                    // 해당 좌표에서 최대 몇마리 잡는지 저장하기 위한 temp, max 비교용
                    int temp  = 0;
            
                    // 해당 좌표에서 M x M만큼 퍼져나가면 됨.
                    for(int i2 = i; i2<M+i; i2++) {
                        for(int j2 = j; j2<M+j; j2++) {

                            if(i2 < N && j2 < N) {
                                temp += arr[i2][j2];
                            }
                            
                        }
                    }

                    if(temp > max) {
                        max = temp;
                    }
    
                }

                //다 잡고 나와서 max와 비교
               
            }



            sb.append("#").append(t).append(" ").append(max).append("\n");



        } // tc loop


        bw.write(sb.toString().trim());
        bw.flush();


    }
}