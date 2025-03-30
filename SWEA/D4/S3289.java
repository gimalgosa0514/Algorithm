package SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class S3289 {


    static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=T; t++) {

            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            
            p = new int[n+1];

            for(int i = 1; i<=n; i++) {
                makeSet(i);
            }
            
            for(int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int command = Integer.parseInt(st.nextToken());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                switch(command) {
                    case 0 :
                        union(a,b);
                        break;
                    case 1: 
                        sb.append(isSame(a, b));
                        break;
                        
                }

            }

            sb.append("\n");

        } // tc loop

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    static int isSame(int a, int b) {
        if(findSet(a) == findSet(b)) {
            return 1;
        } else {
            return 0;
        }
    }

    static int findSet(int x) {
        if(p[x] != x) {
            p[x] = findSet(p[x]);
        } 
        return p[x];
    }

    static void union(int x, int y) {

        p[findSet(y)] = findSet(x);
    }

    static void makeSet(int x) {

        p[x] = x; // 자기 자신을 가리키도록
        
    }

}
