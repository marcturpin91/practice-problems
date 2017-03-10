/**
 * Created by Marc on 2017-03-09.
 */

/*
Problem Description:
You are given an integer N. Print the factorial result of this number.

Input:
Input consists of a single integer N, where 1 <= N <= 100.

Output
Print the factorial of N.

Example
For an input of 25, you would print 15511210043330985984000000.

We recommend solving this challenge using BigIntegers.
 */

import java.util.*;
import java.math.*;

public class ExtraLongFactorialProblem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.println(fact(sc.nextInt()));
    }

    public static BigInteger fact(int x){
        return factHelper(x, BigInteger.valueOf(1));
    }

    public static BigInteger factHelper(int x, BigInteger sum){
        if(x == 1){
            return sum;
        }

        return factHelper((x - 1), sum.multiply(BigInteger.valueOf(x)));
    }
}