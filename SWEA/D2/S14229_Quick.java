import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S14229_Quick {


     static final int N = 1000000;
    static int[] temp = new int[N];
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/SSAFY/Downloads/inp.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        // 배열 초기화.
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N-1);

        bw.write(String.valueOf(arr[500000]));
        bw.flush();
        bw.close();


    }


    public static void quickSort(int start, int end) {
        if(start<end) {
            int pivot = partition(start, end);
            quickSort(start, pivot-1);
            quickSort(pivot+1, end);
        }
    }

    static int partition(int start, int end) {
        int pivot = arr[end]; 

        int i = start-1;
        for(int j = start; j<end; j++) {
            if(arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = tmp;

        return i+1;

    }

     


}
