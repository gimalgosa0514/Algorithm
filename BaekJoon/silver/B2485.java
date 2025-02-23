import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2485 {
    // 거리들간의 최대 공약수를 이용해 몇개의 나무를 심을 수 있는 판단하는... 
    // 머리가 아파서 이해가.. 
    static int[] tree;
    public static void main(String[] args) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        tree=new int[N];
        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(tree);
        int gcd = 0;
        for(int i = 0; i<N-1; i++) {
            int distance = tree[i+1] - tree[i];
            gcd = gcd(distance, gcd);
        }
        System.out.println((tree[N-1] - tree[0]) / gcd+1 - (tree.length));


    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
