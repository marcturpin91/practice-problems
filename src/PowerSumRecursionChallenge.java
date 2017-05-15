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
        return powerSumHelper(x, power, 0);
    }

    // 'x' is remaining sum and 'i' is the current iteration. Iterations go from 0 to i^power, where i^power <= x
    public static int powerSumHelper(int x, int power, int i){

        x = x - (int)(Math.pow(i, power));

        if(x == 0){ return 1; }
        if(x < 0){ return 0; }

        int numOfSums = 0;

        for(int j = i + 1; Math.pow(j, power) <= x; j++){
            numOfSums += powerSumHelper(x, power, j);
        }

        return numOfSums;
    }

}
