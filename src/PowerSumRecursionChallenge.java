/**
 * Created by Marc on 2017-05-10.
 */

/*
Problem description:
Find the number of ways that a given integer, X, can be expressed as the sum of the Nth power of unique, natural numbers.
Input:
The first line contains an integer X.
The second line contains an integer N.
Output:
Output a single integer, the answer to the problem explained above.

Example 1:
Input 10 2
Output 1
Explanation: This is the only way in which 10 (1st input) can be expressed as the sum of unique squares (2nd input).
--> 3^2 + 1^2 = 10

Example 2:
Input 100 2
Output 3
Explanation: 100 = 10^2 = 6^2 + 8^2 = 1^2+ + 3^2 + 4^2 + 5^2 + 7^2

 */

import java.util.Scanner;

public class PowerSumRecursionChallenge {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int power = input.nextInt();
        System.out.println(powerSum(x, power));
    }

    public static int powerSum(int x, int power){
        // we can use the root of the number x to determine maximum possible int in the combination
        // if root is perfect (ie no fraction), that is one of the sums
        // ex with power(25, 2) -> sqrt(25) = 5

        // Maybe should use helper method
        // need to go from root to 0, calling powerSum for each i

        // not sure if necessary here, more so in helper method since that will be recursive, not this one
        if(x == 0){
            return 1;
        }

        // initial root of x
        int root = (int)(Math.floor(Math.pow(x, (1/power))));

        for(int i = root; i > 0; i--){
            // call helper method here
            // p
        }
        return 0;
    }
}
