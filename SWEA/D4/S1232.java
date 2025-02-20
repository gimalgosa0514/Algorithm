import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S1232 {

    
    static String[][] tree;
    static int N;
   
    static StringBuilder expression;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        for(int t = 1; t<=10; t++) {

            N = Integer.parseInt(br.readLine());
            expression = new StringBuilder();
            tree = new String[N+1][3];

            for(int i = 1; i<=N; i++) {
                
                String[] inputs = br.readLine().split(" ");

                // tree에 값넣기~
                for(int j = 0; j<inputs.length-1; j++) {
                    tree[Integer.parseInt(inputs[0])][j] = inputs[j+1];
                }



            }


            postOrder(1);
            String[] expressionArr = expression.toString().trim().split(" ");
            Stack<Integer> s = new Stack<>();
            
            for(int i = 0; i<expressionArr.length; i++) {
                if(expressionArr[i].charAt(0) <='9' && expressionArr[i].charAt(0) >= '0') {
                    s.push(Integer.parseInt(expressionArr[i]));
                } else {
                    char c = expressionArr[i].charAt(0);
                    int b = s.pop();
                    int a = s.pop();
                    switch (c) {
                        case '-':
                            s.push(a-b);
                            break;
                        case '+':
                            s.push(a+b); 
                            break;
                        case '/':
                            s.push(a/b);
                            break;
                        case '*':
                            s.push(a*b);
                            break;
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(s.pop()).append("\n");
            
        }// tc loop 

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }



    public static void postOrder(int i) {

        if(i<=N) {

            // 왼쪽노드가 있다면~
            if(tree[i][1] != null) {
                postOrder(Integer.parseInt(tree[i][1])); // 가라.
            }
            if(tree[i][2] != null) {
                postOrder(Integer.parseInt(tree[i][2])); //  오른쪽 노드 있으면 넌 가라~
            }

            if(tree[i][1] == null || tree[i][2] == null) {
                expression.append(tree[i][0]).append(" ");
            } else {
                expression.append(tree[i][0]).append(" ");
            }




        }

    }
}
