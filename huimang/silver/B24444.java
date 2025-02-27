import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444 {


    static int node;
    static int line;
    static int start;
    static int[] check;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int count = 1;


    public static void main(String[] args) throws IOException{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
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

        for(int i = 0; i<arr.length; i++) {
            arr[i].sort(Collections.reverseOrder());
        }

        bfs(start);

        for(int i = 1; i<check.length; i++) {
            sb.append(check[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close(); 

        
    }
    public static void bfs(int start) {
        q.add(start);
       
        check[start] = count;
        while(!q.isEmpty()) {
            start = q.poll();
            for(int next : arr[start]) {
                if(check[next] == 0) {
                    count++;
                    check[next] = count;
                    q.add(next);
                }
            }

        }


    }
}
