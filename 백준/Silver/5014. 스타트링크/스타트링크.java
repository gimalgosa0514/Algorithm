import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int total;
    static int goal;
    static int now;
    static int up;
    static int down;
    
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        

        total = sc.nextInt();
        now = sc.nextInt();
        goal = sc.nextInt();
        up = sc.nextInt();
        down = sc.nextInt();
        visited  = new boolean[total+1];
        bfs(now);

        if(result == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }

    }

    public static void bfs(int start) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start,0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] currNode = q.poll();

            int curr = currNode[0];

            int upStair = curr + up;
            int downStair = curr - down;

            if(curr == goal) {
                result = Math.min(result, currNode[1]);
            }


            if(upStair < total+1 && !visited[upStair]) {
                q.add(new int[] {upStair, currNode[1]+1});
                visited[upStair] = true;
            }
            if(downStair >= 1 && !visited[downStair]) {
                q.add(new int[] {downStair, currNode[1]+1});
                visited[downStair] = true;
            }

        }


    }
}
