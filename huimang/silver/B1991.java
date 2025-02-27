import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class B1991 {
// 삽입이 중요한 문제였다. 삽입을 할 때도 재귀를 통해 왼쪽 오른쪽으로 나눠서 가야함.
// 이때 null인지, 아닌지를 판별하는게 좀 중요하다. 안그럼 터짐.. 

    static Node head = new Node('A');


    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        

        int N = Integer.parseInt(br.readLine());
       
      
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            char c = st.nextToken(" ").charAt(0);
            char l = st.nextToken(" ").charAt(0);
            char r = st.nextToken(" ").charAt(0);
           
            insertNode(head, c, l, r);
        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        sb.append("\n");
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
    
    
    public static void insertNode(Node temp, char root, char left, char right) {

        if(temp.value == root) {
            temp.left = new Node(left);
            temp.right = new Node(right);
        } else {
            // root노드가 null이면 터져버리잖아. 아무것도 안들어가있으면 씹어야함. 이 문제에서는 C에서 터짐.
            if(temp.left != null)insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right,root, left,right);
        }
    }

    
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        if(root.value != '.') {
            sb.append(root.value);
        }
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        if(root.value != '.') {
            sb.append(root.value);
        }
        inOrder(root.right);
    }
    
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if(root.value != '.') {
            sb.append(root.value);
        }
    }


    static class Node {
        char value;
        Node left;
        Node right;

        Node(char c) {
            value = c;
        }
    }


    

}
 