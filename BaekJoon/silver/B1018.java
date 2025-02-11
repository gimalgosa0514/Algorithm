import java.util.Scanner;

public class B1018 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        String[][] arr = new String[N][M];

        for(int i = 0; i<N; i++) {
            arr[i] = sc.next().split("");
        }


        String[][] originalChess = new String[N][M];
        int flag = 0;
        if(arr[0][0] == "W") {
            flag =1;
        }

        for(int i =0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(flag == 0) {
                    originalChess[i][j] = "B";
                    flag = 1;
                } else {
                    originalChess[i][j] = "W";
                    flag = 0;
                }
            }
        }

        int count = 0;

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(originalChess[i][j] != arr[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
