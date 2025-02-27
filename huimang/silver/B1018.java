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

        // 최소값을 구하기 위함임.
        int min = 1000000000;
        for(int i = 0; i<N; i++) {


            // 최소값 임시 저장소
            int tempMin =0;
          
            for(int j = 0; j<M; j++) {

                // 내부에 한번 더 돎. 그리고 경우의수가 2개이기 때문에 
                // 그 두개 중 최소를 구하는거라.
                int temp1Min = 1000000000;
                int temp2Min = 1000000000;

                // 기존의 값을 벗어나면 체스판이 8x8이 될 수 없음.
                if(i + 8 > N) {
                    break;
                }

                if(j + 8 > M) {
                    break;
                }
                
            
                int count = 0;

                String[][] chess = new String[8][8];
                // W로 시작했을 때
                String str = "W";
                for(int i2 = 0; i2<8; i2++) {
                    for(int j2 = 0; j2<8; j2++) {
                        chess[i2][j2] = str;
                        //번갈아가면서 나와야 하니까.
                        if(str.equals("W")) {
                            str = "B";
                        } else {
                            str = "W";
                        }
                        // 근데 j2가 끝자락이다? 그럼 다음 시작은 마지막 앞 열 마지막 행과 같음.
                        if(j2 == 7) {
                            str = chess[i2][j2];
                        }
                        //원본 판이랑 비교했을 때 다르면 바꿔야 하는 부분이니까 카운트 해줌.
                        if(!chess[i2][j2].equals(arr[i+i2][j+j2])) {
                            count++;
                        }

                    } 
                }

                temp1Min = count;
                chess = new String[8][8];
                count = 0;
                str = "B";
                // 이번엔 Black으로 시작.
                for(int i2 = 0; i2<8; i2++) {
                    for(int j2 = 0; j2<8; j2++) {
                        chess[i2][j2] = str;
                        if(str.equals("W")) {
                            str = "B";
                        } else {
                            str = "W";
                        }

                        if(j2 == 7) {
                            str = chess[i2][j2];
                        }

                        if(!chess[i2][j2].equals(arr[i+i2][j+j2])) {
                            count++;
                        }

                    } 
                }
                temp2Min = count;
                
                // 흑시작 백시작 비교해서 더 작은거 tempMin에 집어넣고 .이게 현재 최소보다 작으면 집어넣음.
                if(temp1Min < temp2Min) {
                    tempMin = temp1Min;
                } else {
                    tempMin = temp2Min;
                }
                if(tempMin < min) {
                    min = tempMin;
                }
            }
            
        }
        

        // 출력
        System.out.println(min);
    }
}
