import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1145 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers = new int[5];
        
        // 입력 받고
        for(int i = 0; i<5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        // 1부터 시작하자.
        int num = 1;
        while(true) {

            // count가 3개 이상이면 탈출하면 됨.
            int count = 0;


            // 나눠 떨어진다? 그럼 카운트 증가~
            for(int i = 0; i<numbers.length; i++) {
                if(num % numbers[i] == 0) {
                    count++;
                }
            }
            // 카운트 3보다 크면 탈출, 아니면 증가해서 다시 루프 돌아..
            if(count >= 3) {
                break;
            }

            num++;
        }

        // 출력.

        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();


    }
}
