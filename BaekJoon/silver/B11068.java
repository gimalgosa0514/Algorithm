import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B11068 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=  new StringBuilder();

        
        int t = Integer.parseInt(br.readLine());

        
        for(int i = 0; i<t; i++) {

            int n = Integer.parseInt(br.readLine());
            
            boolean flag = false;;
            for(int j = 2; j<=64; j++) {
              
                if(isPalindrome(n, j)) {
                    flag = true;
                    sb.append(1).append("\n");
                    break;
                }
            }
            
            if(!flag) {
                sb.append(0).append("\n");
            }

             


        }

        bw.write(sb.toString());
        bw.flush();
    }


    public static boolean isPalindrome(int n, int radix) {

        // 리스트로 받아줌. 왜? 일단 10진법 아래의 수는 문자열로 받으나, 리스트로 받으나 그대로임.
        // 1111 -> 1,1,1,1 해서 리스트를 회문검색을 swap해서 하듯이 해버리면, 결과가 나오는데;;
        // 여기서 문제가 10진법 초과부터임. 이때부터는 알파벳이 들어감. 그래서 문자열로 해도 
        // 되긴 할껀데, 나는 그냥 리스트로 넣어버리면 만약 16진수 FF이면 
        // 15, 15이렇게 리스트에 들어갈꺼란 말임, 그럼 똑같기 때문에 
        // 리스트에 넣어버림.
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n%radix);
            n = n / radix;
        }
        
        for(int i = 0; i<list.size()/2; i++) {
            if(!list.get(i).equals(list.get(list.size()-1-i))) {
                return false;
            }
        }
        return true;

    }

}