/**
 * Created by Marc on 2017-05-08.
 */

/* Problem info:
Output one integer, the GCD of the two given numbers.

Sample Input
1 5
Sample Output
1

Sample Return Values:
GCD(1,5) = 1
GCD(10,100) = 10
GCD(22,131) = 1
 */

import java.util.Scanner;

public class ComputingGCD {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int numerator = Math.max(a,b);
        int denominator = Math.min(a,b);
        computeGCD(numerator,denominator);
    }

    // Method that computes and prints the GCD using the Euclidean algorithm
    /* example of algorithm:
    GCD(10; 45)
    45 = 10 * q + r
    45 = 10 * 4 + 5
    10 = 5 * q + r
    10 = 5 * 2 + 0
    GCD(10;45) = 5
     */
    public static void computeGCD(int num, int denom) {
        int remainder = num % denom;
        if(remainder == 0){
            System.out.println(denom);
        } else {
            computeGCD(denom, remainder);
        }
    }
}
