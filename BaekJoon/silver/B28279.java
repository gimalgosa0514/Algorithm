import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;


public class B28279 {



    private static Deque<Integer> list = new ArrayDeque<>();
    
    public static int size() {
        return list.size();
    }

    public static void addFirst(int x) {
        list.addFirst(x);
    }
    
    public static void addLast(int x) {
        list.addLast(x);
    }

    public static int peekFirst() {
        if(!list.isEmpty()) {
            return list.peekFirst();
        }
        return -1;
        
    }

    public static int peekLast() {
        if(!list.isEmpty()) {
            return list.peekLast();
        }
        return -1;
       
    }

   public static int pollFirst() {
        if(!list.isEmpty()) {
            int r = list.pollFirst();
            return r;    
        }
        return -1;
    
        
   }
   public static int pollLast() {
        if(!list.isEmpty()) {
            int r = list.pollLast();
            return r;
        }
        return -1;
     
   }
    public static int isEmpty() {  
        if(list.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++) {
            String[] commands = br.readLine().split(" ");

            int a = Integer.parseInt(commands[0]);

            switch (a) {
                case 1:
                    addFirst(Integer.parseInt(commands[1]));
                    break;
                case 2:
                    addLast(Integer.parseInt(commands[1]));
                    break;
                case 3:
                    sb.append(pollFirst()).append("\n");
                    break;
                case 4:
                    sb.append(pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(size()).append("\n");
                    break;
                case 6:
                    sb.append(isEmpty()).append("\n");
                    break;

                case 7:
                    sb.append(peekFirst()).append("\n");
                    break;

                case 8:
                    sb.append(peekLast()).append("\n");
                    break;
                
                
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}