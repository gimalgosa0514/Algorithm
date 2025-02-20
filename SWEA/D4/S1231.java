import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1231 {

    static String[][] arr;
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();


        for(int t = 1; t<=10; t++) { 
            
            N = Integer.parseInt(br.readLine());
           
            arr = new String[N+1][3];

            for(int i = 1; i<=N; i++) {

                String[] inputs = br.readLine().split(" ");
                for(int j = 0; j<inputs.length-1; j++) {
                    arr[Integer.parseInt(inputs[0])][j] =  inputs[j+1];
                }
            } 
            sb.append("#").append(t).append(" ");
            inOrder(1);
            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void inOrder(int v) {
        if(v <= N) {
            if(arr[v][1] != null) {
                inOrder(Integer.parseInt(arr[v][1]));
            } 
            if(arr[v][1] == null && arr[v][2] == null) {
                sb.append(arr[v][0]);
            } else {
                sb.append(arr[v][0]);
            }
            if(arr[v][2] != null) {
                inOrder(Integer.parseInt(arr[v][2]));
            }
           
        }
       
    }
}
