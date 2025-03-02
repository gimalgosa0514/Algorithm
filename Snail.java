public class Snail {
    public static void main(String[] args) {
        int N = 4;
        int[][] arr = new int[N][N];
        int K = N;
        int dir = 1;
        int r = 0;
        int c = -1;
        int num = 1;
        while(true) {

            for(int i = 0; i<K; i++) {
                c += dir;
                arr[r][c] = num++;
            }
            K--;
            if(K == 0) break;

            for(int j = 0; j<K; j++) {
                r += dir;
                arr[r][c] = num++;
            }
            dir = -dir;
        }

        for(int i = 0; i<4; i++) {
            for(int j = 0; j<4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
