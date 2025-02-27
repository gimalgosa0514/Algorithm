import java.util.Scanner;

public class B13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long gcd = 0;
        if(a>b) {
            gcd =gcd(a,b);
        } else {    

            gcd = gcd(b,a);
        }

        System.out.println(a*b/gcd);


    }

    public static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
