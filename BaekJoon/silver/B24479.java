import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B24479 {


    static int node;
    static int line;
    static int start;

    // 메모리 초과때문에 인접행렬 x
    static ArrayList<Integer>[] arr;
    
    // 방문 순서를 출력해야해서. check를 불리언이 아닌 방문 순서를
    // 저장하는 방시긍로
    static int[] check;
    static StringBuilder sb = new StringBuilder();

    // 첫번재부터 방문이니깐
    static int count = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line =  Integer.parseInt(st.nextToken());
        start =  Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        check = new int[node+1];


        for(int i = 0; i<node+1; i++) {
            arr[i] = new ArrayList<>();
        }



        for(int i = 0; i<line; i++) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(inputs.nextToken());
            int b = Integer.parseInt(inputs.nextToken());
            arr[a].add(b);
            arr[b].add(a);
            

        }

        // 오름차순을 위해 정렬
        for(int i = 0; i<node+1; i++) {
            Collections.sort(arr[i]);
        }

        dfs(start);


        for(int i = 1; i<check.length;i++) {
            sb.append(check[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


    public static void dfs(int start) {
        // 방문 체크 배열에 카운트 저장.
        check[start] = count;

        

        for(int next : arr[start]) {
            // 만약 0이다? 방문하지 않은거임. 그래서 dfs 가야됨. 
            if(check[next] == 0) {
                count++;
                dfs(next);
            }
        }
     
    }


}
