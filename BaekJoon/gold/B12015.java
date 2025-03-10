package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B12015 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();
        
        for(int i = 0; i<N; i++) {
            if(dp.isEmpty()) {
                dp.add(arr[i]);
            } else {
                if(dp.getLast() < arr[i]) {
                    dp.add(arr[i]);
                    continue;
                }
                // 이진 탐색을 위한 left , right
                int left = 0;
                int right = dp.size()-1;

                while(left < right) {
                    int mid = (left+right) / 2;

                    if(dp.get(mid) > arr[i]) {
                        right = mid;
                    } else {
                        left = mid +1;
                    }
                }
                dp.set(right, arr[i]);
            }
            
        }


        bw.write(String.valueOf(dp.size()));
        bw.flush();
        bw.close();
        

    }
}
