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
        computeGCD(a,b);
    }

    // Method that computes and prints the GCD using the Euclidean algorithm
    public static void computeGCD(int a, int b){}

    // need to recursively use the algorithm here. Base case is when remainder is 0 -> print the previous remainder here

    /* example of algorithm:
    GCD(10; 45)
    45 = 10 * q + r
    45 = 10 * 4 + 5
    10 = 5 * q + r
    10 = 5 * 2 + 0
    GCD(10;45) = 5
     */
}
