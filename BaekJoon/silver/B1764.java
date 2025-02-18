import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// 풀이 : 집합 두 개를 이용하여 각각의 집합에 이름을 입력 받음.
// 한 집합을 반복을 돌며 그 요소가 다른 집합 안에 있는지 확인
// 있으면 그 이름을 리스트에 집어넣고, 나중에 출력.
public class B1764 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        String[] NandM = br.readLine().split(" ");
        
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]); 


        
        Set<String> noListen = new HashSet<>();
        Set<String> noSee = new HashSet<>();
        
        for(int i = 0; i< N; i++) {
            noListen.add(br.readLine());
        }
        for(int i = 0; i< M; i++) {
            noSee.add(br.readLine());
        }


        List<String> list = new ArrayList<>();
        
        for(String name : noListen) {
            if(noSee.contains(name)) {
                list.add(name);
            }

        }

        
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        sb.append(list.size()).append("\n");
        for(String name : list) {
            sb.append(name).append("\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }
}
