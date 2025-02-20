package SWEA.D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1248 {


    static int[][] tree;
    static int V;
    static int[] count;
    static int leafCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t<=tc; t++) {

        
            String[] inputs = br.readLine().split(" ");

            V = Integer.parseInt(inputs[0]);
            int E = Integer.parseInt(inputs[1]);
            int target1 = Integer.parseInt(inputs[2]);
            int target2 = Integer.parseInt(inputs[3]);
            leafCount = 0;
            String[] commands = br.readLine().split(" ");
            count = new int[V+1];
            // 1. 일단 간선대로 트리 만들기.
            // 트리의 크기는 [node + 1][3] -> 두번째 0은 왼쪽 1은 오른쪽 2는 부모.
            
            tree = new int[V+1][3];
            for(int i = 0; i<commands.length-1; i+=2) {
                int p = Integer.parseInt(commands[i]);
                int c = Integer.parseInt(commands[i+1]);
                
                // 부모 노드의 왼쪽 자식이 아무것도 안들어가있다?
                if(tree[p][0] == 0) {
                    tree[p][0] = c; // 자식노드 들어가시고~
                } else {
                    // 왼쪽 자식 차있다? 그럼 오른쪽 들어가시고~ 
                    tree[p][1] = c;
                }
                // 자식노드 부모는 당근빳다링 p
                tree[c][2] = p;
            } // 트리 맹글기
            // 일단 ㅇㅋ임
            
            findRoot(target1);
            findRoot(target2);
            //count 배열에서 제일 처음 2인 애가 가까운 공통조상.
            int josang = 0;
            for(int i = count.length-1; i>0; i--) {
                if(count[i] == 2) {
                    josang = i;
                    break;
                }
            }
            inOrder(josang);
            sb.append("#").append(t).append(" ").append(josang).append(" ").append(leafCount).append("\n");


        } //tc loop

        bw.write(sb.toString());
        bw.flush();


    }

    public static void findRoot(int x) {
        // 부모노드.

        if(tree[x][2] == 0) { // 부모노드가 없다? 그럼 끝임.
            count[x]++;
            return;
        }
        else {
            // 하 이게 중요함... 2되면 바로 끊어버려야함..
            count[x]++;
            if(count[x] == 2) {
                return;
            }
            findRoot(tree[x][2]);
        }
    }

    public static void inOrder(int x) {
        leafCount++;
        if(x<=V) {
            // 좌 우가 0 이면 리프노드.
            
            if(tree[x][0] != 0) {
                inOrder(tree[x][0]);
                
            }
            if(tree[x][0] == 0 && tree[x][1] == 0) {

                return;
            } 
            if(tree[x][1] != 0) {
                inOrder(tree[x][1]);
                
            }
        }
    }

}
