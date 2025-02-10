import java.util.Scanner;



// 선택 정렬 문제 -> 배열, 리스트를 순회하면서 가장 작은 값을 찾아 왼쪽에 배치하면서 정렬 하는거임.
// 시간 복잡도는 O(n2) 
public class B23882 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        
        int K = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        selectionSort(arr,K);
       

    }



    /*작은 수를 찾아서 선택 정렬 하기.
    static void selectionSort(int[] arr) {

        int N = arr.length;

        //i는 0부터, N까지 (N-1이어도 큰 지장 x)
        for(int i = 0; i<N; i++) {
            
            // 최솟값이 i일것이라고 일단은 깔고 시작.
            int min = i; 

            // i+1 번째부터 시작 -> 굳이 i부터 비교할 필요없이, i 다음꺼부터 시작하면 되잖아
            for(int j = i+1; j<N; j++) {
                // 그래서 비교해서 더 작은게 인덱스가 되는거임.
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            
      
            
            // 배열을 순회해서 최솟값을 찾으면 i 번째에, 그 이후에 나온 최솟값의 인덱스를 넣어서 스왑.
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                
            }
            

        
        System.out.println(Arrays.toString(arr));


    }
     */


    // 큰 수 부터 찾아서 선택 정렬 
    public static void selectionSort(int[] arr,int K) {

        int N = arr.length;
        for(int i = N-1; i>0; i--) {

            int maxIdx = i;

            for(int j = i-1; j>=0; j--) {
                if(arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

           

            if(maxIdx != i) {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;
                K--;
                if(K == 0) {
                    
                    for(int k = 0; k<arr.length; k++) {
                        System.out.print(arr[k]+" ");
                         
                    }
                    return;
                }
            }

        }


        System.out.println("-1");



    }


}