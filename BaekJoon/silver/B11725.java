import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11725 {

    static Node head = new Node(1);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       

        int N = Integer.parseInt(br.readLine());

        
        for(int i = 0; i<N-1; i++) {
            String[] commands = br.readLine().split(" ");
            
            int p = Integer.parseInt(commands[0]);
            int c = Integer.parseInt(commands[1]);

            insert(head,p,c);
        }
        inOrder(head);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public static void insert(Node temp, int root, int l) {
        if(temp.value == root) {
            if(temp.left == null) {
                temp.left = new Node(l);
            } else if(temp.right == null){
                temp.right = new Node(l);
            }
        } else {
            if(temp.left != null) insert(temp.left, root, l);
            if(temp.right != null) insert(temp.right, root, l);
        }
    }

    public static void inOrder(Node head) {
        sb.append(head.value);
        if(head.left != null) {
            inOrder(head.left); 
        } 
        if(head.right != null) {
            inOrder(head.right);
        }
        
        
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int v) {
            value = v;
        }
    }

}
