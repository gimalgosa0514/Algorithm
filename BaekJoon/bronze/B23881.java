
// 선택정렬

import java.util.Scanner;

public class B23881 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        
        for(int i = N-1; i>0; i--) {
            int maxIdx = i;
            for(int j = i - 1; j>=0; j--) {
                if(arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }
       
            if(maxIdx != i) {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;

                K--;
                if(K == 0) {
                    System.out.println(arr[maxIdx] + " " + arr[i]);
                    return;
                }
            }

            
        
        }

        System.out.println("-1");



    }
}
