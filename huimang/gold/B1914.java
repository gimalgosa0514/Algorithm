package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class B1914 {
    
    
    static StringBuilder sb = new StringBuilder();
    static String count = "";
    static int cnt = 0;

    //이번 문제는.. 메모리 제한이 걸려있기 때문에...
    // 20까지는 일반 출력 해도 됨.
    // 근데 20이 넘어가는 순간 출력은 안해도 되는데
    // 또 이러면 시간 초과남;;;
    // 그래서 식을 풀어야 하는데, 
    // 수가 워낙 커지기 때문에 BigInteger를 이용해야한다.
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        if(N <=20) {
            // 일반 하노이랑 같음.
            hanoi(N, 1, 3, 2); // N개의 원판을 1에서 3으로 올길건데. 중간 다리는 2이다! 
            count = String.valueOf(cnt);
        } else {

            // 20이 넘어가면 식으로 풀기 시작. 2의 n승 -1임...
            // 그걸 빅 인티져로 구현 해주면 됨.
            BigInteger cnt = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
            count = cnt.toString();
        }
        
        bw.write(count+"\n");
        bw.write(sb.toString());
        bw.flush();
        
        
    }

    
    // 하노이 타워를 재귀로 풀어보자.....
    // 벌써 머리가 아프지만... 하노이타워는, 일단 원판의 수와, 어디서 부터, 어디로 옮길것이고, 중간다리를 
    // 어디로 둘것인지를 받는다.
    public static void hanoi(int N, int from, int to, int temp) {

        // Base: 종료 조건        // 우선 1이면 1에서 바로 c로 갈 수 있잖아..
        if(N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            cnt++;
    
        } else {
            hanoi(N-1,from,temp,to);
            sb.append(from).append(" ").append(to).append("\n");
            cnt++;
            hanoi(N-1,temp,to,from);
        }
        // Recursive : 재귀 호출 부 
        
    }
}
