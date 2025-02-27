package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2447 {

    // 문자를 담을 배열 N*N사이즈로 초기화 해 줘야함.
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        // 재귀 함수 호출.
        draw(0,0,N,false);

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void draw(int x, int y, int N, boolean blank) {

        // BASE 부분 -> 종료조건. 두개임.
        // 만약 blank가 참이면 공백을 size만큼 출력하고 그만임.
        if(blank) {
            for(int i = x; i<x+N; i++) {
                for(int j = y; j<y+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }


        // 위에서 안걸렸는데 사이즈가 1이다? 그럼 * 을 저장.
        if(N == 1) {
            arr[x][y] = '*';
            return;
        }

        // 만약 N이 3이다? 그럼 사이즈는 1이 되고, 쪼그마한 칸들을 채울꺼임.
        int size = N / 3;
        int count = 0;
        for(int i = x; i<x+N; i+=size) {
            for(int j = y; j<y+N; j+=size) {
                count++;
                // 별을 하나씩 찍다가 카운트가 5가 된다? 그럼 공백을 찍어야 하는 부분임.
                // 왜? N 이 3이라고 가정했을 때 1~4까지는 별을 찍다가 1,1이 되는 부분에 싸이즈만큼 공백을 찍어야함.
                if(count == 5) {
                    draw(i,j,size,true);
                } else {
                    draw(i,j,size,false);
                }
            }
        }
    }
    
}
