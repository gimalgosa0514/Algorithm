

// Counting Sort를 이용해보자.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10989 {
    public static void main(String[] args) throws IOException{
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

      
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        
        
        int max = 0;
        for(int i = 0; i<arr.length; i++) {
            arr[i] =  Integer.parseInt(br.readLine());

            
            if(max < arr[i]) {
                max = arr[i];
            }

        }


        int[] countArr = new int[max+1];
        // 이 문제에서는 수의 범위가 1 ~ 10000000까지니까롱
        for(int i = 0; i<arr.length; i++) {
            countArr[arr[i]]++;
        }
        
        // 누적합 만들자~
        for(int i = 1; i<countArr.length-1; i++) {
            countArr[i+1] += countArr[i] ;
        }

        

        //새로 저장할 배열~ 
        int[] sortedArr = new int[N];

        // 거꾸로 순회하면서 누적합 -- 해주면서 출력
        for(int i = arr.length-1; i>=0; i--) {


            // arr 배열의 값이 즉 count 배열의 인덱스.
            int num = arr[i];
            // count배열의 누적합 값에서 -1을 해준게 정렬 된 값의 인덱스 값임.
            int idx = countArr[num]-1;

            // 값 넣어줌!! 
            sortedArr[idx] = num;
            
            //실제로 빼줌
            countArr[num]--;
        } 


        //출력
        for(int i = 0; i<sortedArr.length; i++) {
            sb.append(sortedArr[i]).append("\n");
        }

        bw.write(sb.toString().trim());
        bw.flush();
 
        




    }
}
