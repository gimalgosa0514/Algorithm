import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class S14510 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 나무 수
            int[] trees = new int[N]; // 나무 높이 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;

            // 입력 받으면서 최대 높이 찾기
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }

            int day = 0;
            while (true) {
                if (canGrow(trees, max, day)) {
                    break;
                }
                day++;
            }

            System.out.println("#" + tc + " " + day);
        }
    }

    
    static boolean canGrow(int[] trees, int max, int day) {

        int plus2 = day / 2; // +2가능 횟수
        int plus1 = (day+1) /2; // +1 가능 횟수
        int total = 0; // 총 물 준 횟수

        for(int i = 0; i<trees.length; i++) {
            int need = max - trees[i]; // i번째 나무가 얼마나 커야할지

            int use2 = Math.min(need/2, plus2);
            need -= use2 * 2;
            plus2 -= use2;

            int use1 = Math.min(need, plus1);
            need -= use1;
            plus1 -= use1;

            total += (use2 + use1);

            if(need >0) {
                return false;
            }

            
        }
        return total<=day;
    }

}
