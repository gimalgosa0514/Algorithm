import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 문제로 인해 인접 행렬로 낭비되는 공간을 줄이고자, 리스트 배열을 만들어서 사용해야함.
public class B11725 {

   
    static StringBuilder sb = new StringBuilder();
    static int node;
    static int line;
    static int start=2;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] flag;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       

        node = Integer.parseInt(br.readLine());
        line = node-1;
        parents = new int[node+1];
        arr = new ArrayList[node+1];

        // 리스트 배열 초기화
        for(int i = 1; i<=node; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i< line; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 이렇게 각 리스트에 다음 노드를 추가해주면 됨.
            arr[a].add(b);
            arr[b].add(a);
            
        }

        flag = new boolean[node+1];
 
        start =1;
        bfs(start);

        for(int i = 2;i<=node; i++) {
            sb.append(parents[i]).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int start) {

        q.add(start);
        flag[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            // 탐색 시 해당 인덱스에 연결된 노드가 탐색을 했는지 여부를 보며 탐색.
            for(int next : arr[start]) {
                if(!flag[next]) {
                    flag[next] = true;
                    q.add(next);
                    parents[next] = start;
                    
                }
            }


        }

    }



   
}
