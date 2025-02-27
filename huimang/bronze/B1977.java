import java.util.Scanner;

public class B1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        // 쨋든 N과 M을 받고
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 합
        int sum = 0;

        // 최소값
        int min = Integer.MAX_VALUE;

        // N부터 M까지 반복하는데
        for(int i = N; i<=M; i++) {

            // 1부터 i까지 가보면서 j^2가 되는지 보는거임. 그럼 완전제곱수이니까롱~
            for(int j=1; j<=i; j++) {
                if(j * j == i) {
                    sum += i;
                    if(min > i) {
                        min = i;
                    } 
                }
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
