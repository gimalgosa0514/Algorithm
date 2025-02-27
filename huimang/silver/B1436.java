import java.util.Scanner;

public class B1436{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        // 종말의 수는 666이 포함되어있는 수임.
        // 첫번 째 종말의 수는 666 
        // 두번 째 종말의 수는 첫번째에서 부터 쭉쭉쭉 더해가다가 다음 666이 등장하는 수임.
        // 1666 ㅎㅎㅎ 그러니 쭉 더하면서 666포함 되어있는지 포함되어있으면 카운트 깎으면 되는겅미.
        int start = 666;
        while(n>0) {
            if(String.valueOf(start).contains("666")) {
                n--;
                if(n == 0) {
                   System.out.println(start);
                }
            }

            start++;

        }
    }
}
