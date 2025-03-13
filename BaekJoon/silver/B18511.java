import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class B18511 {


    //Ah.....
    static int N;
    static int K;

    // 이건 뭐 고른애들 넣어 둘 배열하고.. 숫자 주어주는거..
    static int[] sel;
    static int[] arr;


    // 이건 만들 숫자의 길이인데, 최대, N의 자리 수 만큼.
    static int len;

    //최대값 갱신용.
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 변수 받아주고 초기화 까지 해버림
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

       


        // 고르는 배열의 길이를 1부터 N의 자리 수 까지 loop
        for(int i = 1; i<=String.valueOf(N).length(); i++) {
            len = i;
            sel = new int[len];

            comb(0);
        }
       
        

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    // 여기는 음... 뭐라 설명해야하나...?
    // 모든 경우의 수를 보는거임!! 이건 순열인가..?
    // 1, 2, 3이면
    // 1,2,3을 이용해서 len의 길이만큼 만들 수 있는 모든 경우의 수.
    // 중복도 허용함.
    public static void comb(int sIdx) {
        
        if(sIdx == len) {
            StringBuilder sb = new StringBuilder();
            for(int n : sel) {
                sb.append(n);
            }

            int number = Integer.parseInt(sb.toString());
            if(number <= N) {
                max = Math.max(max,number);
            }


            return;
        }

        for(int i = 0; i<K;i++) {
            sel[sIdx] = arr[i];
            comb(sIdx+1);
        } 
    }

}