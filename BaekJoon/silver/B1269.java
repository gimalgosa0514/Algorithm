import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// 풀이 : 차집합은 집합에서 교집합 빼내는건데,
// A의 내용이 바뀌어 버리니까, temp 집합 C를 A 만들 때 똑같이 하나 더 만들어 준게 끝.
public class B1269 {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lens = br.readLine().split(" ");
        
        int aLen = Integer.parseInt(lens[0]);
        int bLen = Integer.parseInt(lens[1]);


        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();
        Set<String> C = new HashSet<>();
        
        String[] aEle = br.readLine().split(" ");
        
        for(int i = 0; i<aLen; i++) {
            A.add(aEle[i]);
            C.add(aEle[i]);
        }

        aEle = br.readLine().split(" ");
        
        for(int i = 0; i<bLen; i++) {
            B.add(aEle[i]);
        }

        
        A.removeAll(B);
        B.removeAll(C);

        int count = 0;
        for(String a : A) {
            count++;
        }
        for(String b : B) {
            count++;
        }
          
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}
