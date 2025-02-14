package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class B25501 {

    static int cnt;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t<T; t++) {
            cnt = 0;
            String str = br.readLine();
            int result = isPalindrome(str);
            sb.append(result).append(" ").append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

    }

    public static int recursive(String str, int l, int r) {
        cnt++;
        if(l>=r) {
            return 1;
        } else if(str.charAt(l) != str.charAt(r)) {
            return 0;
        } else {
            return recursive(str, l+1, r-1);
        }

        
    }
    public static int isPalindrome(String str) {
        return recursive(str, 0, str.length()-1);
    }
}
