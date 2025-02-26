import java.util.Scanner;


public class B2231 {
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
                
        int N = sc.nextInt();


        // 최소값을 담을 칭구이자 플래그 역할도 하자~
        int min = 0;
        for(int i =1; i<=N;i++) {
            
            String numberStr = String.valueOf(i);
            int sum = i;
            // 원래 값에서 각 자리수를 잘라서 더해.
            for(int j = 0 ; j< numberStr.length();j ++) {
                sum += numberStr.charAt(j)-'0';
            }
            
            

            // 같으면 바로 탈출 (최소값이니깐)
            if(sum == N) {
                min = i;
                break;
            }
          
        }

        // 근데 끝까지 못찾았다? 그럼 없는거니 0
        if(min == 0) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }


    }
}
