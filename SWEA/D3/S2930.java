import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2930 {

    static int[] heap;
    static int heapSize;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t<=tc; t++) {
        
            heap = new int[1000000];
            heapSize= 0; // 저는 버러지 입니다..
            
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");
            
            for(int i = 0; i<N; i++) {
                String[] commands = br.readLine().split(" ");


                switch (Integer.parseInt(commands[0])) {
                    case 1:
                        insert(Integer.parseInt(commands[1]));
                        break;

                    case 2:
                        sb.append(heapPop()).append(" ");
                        break;
                
                }
            }


            sb.append("\n");
            

        } // tc Loop


        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }


    public static void insert(int x) {

        //1. 일단 제일 말단에 넣어버림.
        
        heap[++heapSize] = x;

        //2. 그다음에 위에꺼랑 비교하면서 올라가는거임.

        
        int ch = heapSize; // 자식 노드
        int p = ch/2; // 부모노드 찾아가는공

        while(p > 0 && heap[ch] > heap[p]) { // 이때 부모노드의 인덱스가 0보다 크고, 자식이 더 클때만 반복할꺼임.
            int tmp = heap[ch];
            heap[ch] = heap[p];
            heap[p] = tmp;
        
        
            // 얘네 인덱스 돌려줘야지.. 
            ch = p; 
            p = ch / 2; 
        }

    }

    public static int heapPop() {

        if(heapSize== 0) {
            return -1;
        }

        // 1. 일단 제일 위에꺼 버려버려~ 근데 걍 최 말단 노드로 덮어버리자. 자식 노드를 빼야해.

        int root = heap[1]; // 얘가 젤 큰 칭구임. 이칭구가 일단은 리턴 값이니 가지고 이쑹.ㅁ

        heap[1] = heap[heapSize--]; // 막냉이 박아넣고 주려벌임  ㄱㄱㄱ.
        


        // 부모랑 자식 세팅인데, 우측 노드의 값이 더 크면, 우선순위가 더 높으니께 우측노드로 세팅.
        int p = 1;
        int ch = p*2;
        if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) { // 일단 우측으로 벗어나면 안댕께 조건을 추가해줘야함.
            ch = ch+1;
        }

        while(ch<=heapSize && heap[p] < heap[ch]) { // 마찬가지로 ch가 heapSize보다 작거나 같고, (안그러면 뻑나잖아;;) 자식이 더 클때 = 왜냐면 부모노드자리랑 바꿔줘서 올려줘야하니깐~ 최대힙이라 그럼 ㅎ

            int tmp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = tmp;

            p = ch;
            ch = p*2;
            if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
                ch +=1;
            }
        }

        return root;
        

    }
}
