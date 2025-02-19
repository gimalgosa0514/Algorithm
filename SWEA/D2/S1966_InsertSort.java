import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 삽입 정렬
public class S1966_InsertSort {
    public static void main(String[] args) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N];
            String[] strArr = br.readLine().split(" ");
            for(int i = 0; i<N; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }



            // 첫번째 루프는 비정렬 집합이라고 생각하면 됨.
            for(int i = 1; i<N; i++) {
                int target = arr[i]; // i번째는 정렬 집합의 어디에 삽입할 건지 target이 되는 칭구임.

                int j = 0; // j는 index라고 생각하면 됨.
                for(j = i-1; j>=0 && arr[j] > target; j--) { // i-1번째 부터가 정렬됩 집합의 뒷쪽이다.
                    // 거기서부터 쭉 쭉 나가는데 0까지 가면 되겠지, 그리고 arr[j] 가  target보다 커야 쭉 쭉 내려갈꺼임.(오름차순이니까)
                    // 해서 target이 작은 j 즉 자리 찾아가면 스돕.
                    arr[j+1] = arr[j]; // 뒤로 쭉 쭉 댕기는 과정임.
                }
                j++; // 반복이 끝난 상태면 j는 target을 삽입하려는 전 자리일꺼임. 그래서 하나 더해줌.
                arr[j] = target; // 삽입

            }

            sb.append("#").append(t).append(" ");
            for(int i = 0; i<N; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
