import java.util.Scanner;

public class S1217 {
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        for(int t = 1; t<=10; t++) {
            int tc = sc.nextInt();

            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println("#"+t+" "+power(N, M));
        }

    }

    static int power(int N, int M) {

        // BASE : 재귀를 빠져나가기 위한 조건.
        if(M == 1) {
            return N * M;
        }
        // Recursive Case : 자신을 호출하는 부분! 

        return N * power(N, M-1);
    }
}
