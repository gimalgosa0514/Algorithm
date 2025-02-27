import java.util.Scanner;

public class B2839 {
   public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        // 5의 개수를 최대에서 점점 줄여가는거임.
        int maxFive = n/5;

      


        while(maxFive >= 0) {
            // 우선 뭐 몫이 0이든 몇이든 간에 몫 x 5 하면 남은 무게가 나옴.
            int remainder = n - (5* (maxFive)); // 남은 무게

            // 그 나머지가 3으로 나누어 떨어진다? 그럼 두개 더하면 되는거고.
            if(remainder % 3 == 0) {
                System.out.println(maxFive + (remainder/3));
                return;
            } 


            // 안나누어 떨어지면 점점 maxFive를 줄여나가는거임.
            // 그러다가 maxFive가 음수보다 작아지면, 3만으로도 안나누어 떨어지는 거니까 끝.
            maxFive--;

        }
        System.out.println(-1);
   } 
}
