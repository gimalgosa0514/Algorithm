import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S3499 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

         
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {

            // 카드 덱 크기 
            int N = Integer.parseInt(br.readLine());

            String[] cards = br.readLine().split(" ");

            // 이제 나눌껀데... 짝 홀에 따라 나뉨.
            int deck1Length = 0;
            
            if(N % 2 == 0) {
                deck1Length = cards.length/2;
            } else {
                deck1Length = cards.length/2+1;
            }
            String[] deck1 = null;
            String[] deck2 = null;
            if(N % 2 == 0) {
                deck1 = Arrays.copyOfRange(cards, 0, deck1Length);
                deck2 = Arrays.copyOfRange(cards, cards.length-deck1Length, cards.length);
            } else {
                deck1 = Arrays.copyOfRange(cards, 0, deck1Length);
                deck2 = Arrays.copyOfRange(cards, cards.length-deck1Length+1, cards.length);
            }
            
            sb.append("#").append(t).append(" ");
            for(int i = 0; i<deck1Length; i++) {
                if(i >= deck2.length) {
                    sb.append(deck1[i]);
                } else {
                    sb.append(deck1[i]).append(" ").append(deck2[i]).append(" ");
                }
            }

            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
    }
}
