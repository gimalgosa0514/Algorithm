package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B4779 {
    

    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while((line = br.readLine()) != null && !line.equals("" ) ) {


            int N = Integer.parseInt(line);
            int length = (int) Math.pow(3, N);

            char[] arr = new char[length];

            Arrays.fill(arr, '-');
            recursive(arr,0,length);
            sb.append(new String(arr)).append("\n");
            
            

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void recursive(char[] arr, int start, int length) {
        
        if(length < 3) return;

        int segment = length/3;

        for(int i = start+segment; i< start + 2 * segment; i++) {
            arr[i] = ' ';
        }

        recursive(arr, start, segment);
        recursive(arr, start + 2 * segment, segment);
        
    }
}
