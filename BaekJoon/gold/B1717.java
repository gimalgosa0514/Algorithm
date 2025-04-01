package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1717 {


    static int[] p;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n+1];
        

        // makeSet
        for(int i = 0; i<=n; i++) {
            p[i] = i;
        }
        
        
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0:
                    union(a,b);
                    break;
            
                case 1:
                    sb.append(isSame(a,b)).append("\n");
                    break;
            }


        } 

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    static String isSame(int x, int y) {

        if(findSet(x) == findSet(y)) {
            return "yes";
        } else {
            return "no";
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


}
