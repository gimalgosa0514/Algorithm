import java.util.Scanner;

public class B1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a_ja = sc.nextInt();
        int a_mo = sc.nextInt();
        int b_ja = sc.nextInt();
        int b_mo = sc.nextInt();


        int gcd = 0;
        if(a_mo > b_mo) {
            gcd = gcd(a_mo, b_mo);
        } else {
            gcd = gcd(b_mo, a_mo);
        }

        int lcm = a_mo * b_mo / gcd;
        
        int temp_a = lcm / a_mo;
        int temp_b = lcm / b_mo;

        int jaSum = a_ja * temp_a + b_ja * temp_b;
        int temp_gcd = 0;
        if(lcm > jaSum) {
            temp_gcd = gcd(lcm,jaSum);
        } else {
            temp_gcd = gcd(jaSum,lcm);
        }

        System.out.print(jaSum / temp_gcd + " " + lcm / temp_gcd);

    }   
    
    
    


    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b,a%b);
        }
    }
}
