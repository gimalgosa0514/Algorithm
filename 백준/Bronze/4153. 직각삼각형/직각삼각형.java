
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(Math.max(a,b),c);
            
            if(max == a) {
                b = b;
                c = c;
            } else if(max == b) {
                b = a;
                c = c;
            } else if(max == c) {
               c = a;
               b = b;
            }


            if(Math.pow(max, 2) == (Math.pow(b, 2) + Math.pow(c, 2))) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }


        
    }
}
