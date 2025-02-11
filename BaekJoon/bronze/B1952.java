import java.util.Scanner;

public class B1952 {
    public static void main(String[] args) {
        
        
        
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();

        
        int KM = M;
        int KN = N;


        int r = 0;
        int c = -1;

        int dir = 1;
        int num = 1;


        int[][] snail = new int[M][N];
        int count = 0;
        while(true) {
              
            // 수평 -> 수직
            for(int i = 0; i<KN; i++) {
                c += dir;
                snail[r][c] = num++;
            } 

            // 위 아래 크기가 다르니까 다르게 가 줘야함.
            KN--;
       
            if(num > M * N) break;
            count++;
         
            // 수직 -> 수평
            for(int i = 0; i<KM-1; i++) {
                r +=dir;
                snail[r][c] = num++;
            }

            // 위 아래 크기가 다르니까 다르게 가 줘야함.
            KM--;

            // 방향 전환! 
            dir = -dir;


            // 여기서 끝날 수도 있으니까.
            if(num > M * N) break;
            count ++;
            
            
           
        }

       
    
        System.out.println(count);

    }
}
