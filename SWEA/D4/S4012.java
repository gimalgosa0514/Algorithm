import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class S4012 {

    static int N;
    static int[] sel;
    static int[][] arr;
    static boolean[] selected;
    static int min;
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            
            N = Integer.parseInt(br.readLine());
            
            arr = new int[N][N];
            min = Integer.MAX_VALUE;
            sel = new int[N/2];
            selected = new boolean[N];
            for(int i = 0; i<N; i++) {
                String[] inputs = br.readLine().split(" ");

                for(int j = 0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }


            }

            comb(0,0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    public static void comb(int idx, int sidx) {

        // 두개 다 고르면 리턴 해보려라이잉~~
        if(N/2 == sidx) {
            calculateSyn();
            return;
        }
        
        
        if(idx == N) {
            return; // 더이상 검사할 재료가 없음.
        }

        sel[sidx] = idx;
        selected[idx] = true;
        comb(idx+1, sidx+1);

        selected[idx] = false;
        comb(idx+1,sidx);

    }



    public static void calculateSyn() {
        int sumA = 0, sumB = 0;
        List<Integer> listNotSelected = new ArrayList<>();
        
        // 일단 선택 안된애들 리스트에 다 집어넣어버려.
        for(int i = 0; i<N; i++) {
            if(!selected[i]) listNotSelected.add(i); 
        }


        // A 시너지 계산해줘
        for(int i = 0; i<N/2; i++) {
            for(int j = i+1; j<N/2; j++) {
                sumA += arr[sel[i]][sel[j]] + arr[sel[j]][sel[i]];
            }
        }
        
        // 이제 B 계산
        for(int i = 0; i<N/2; i++) {
            for(int j = i+1; j<N/2; j++) {
                sumB += arr[listNotSelected.get(i)][listNotSelected.get(j)] + arr[listNotSelected.get(j)][listNotSelected.get(i)];
            }

        }

        min = Math.min(min, Math.abs(sumA-sumB));
    }
 
    
}