/**
 * Created by Marc on 2016-11-30.
 */

/*
Context & Instructions:
The Fibonacci sequence begins with fibonacci(0) = 0 and fibonacci(1) = 1
as its respective first and second terms. After these first two elements,
each subsequent element is equal to the sum of the previous two elements.

Here is the basic information you need to calculate fibonacci(n):
fibonacci(0) = 0
fibonacci(1) = 1
fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

Given n, complete the fibonacci function so it returns fibonacci(n).

Input Format:
Locked stub code in the editor reads a single integer denoting the value
of n and passes it to the fibonacci function.


*/

import java.util.*;

public class FibonacciChallenge {

    public static int fibonacci(int n) {
        // Complete the function.

        // Base Cases
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        // Recursive Case
        return fibonacci(n-1) + fibonacci(n-2);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
