/**
 * Created by Marc on 2016-11-20.
 */

/*
Context & Instructions:
In this problem, you are given N integers. You need to find
the maximum number of unique integers among all the possible
contiguous subarrays of size M.
Note: Time limit is 3 second for this problem.

Input Format:
The first line of input contains two integers N and M: representing
the total number of integers and the size of the subarray,
respectively. The next line contains N space separated integers.
Ex:
6 3
5 3 5 2 3 2

Output Format:
Print the maximum number of unique integers among all possible
contiguous subarrays of size M.
Ex:
3

Constraints:
1 <= N <= 100,000
1 <= M <= 100,000
M <= N
*/

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class MaxUniqueNumbersSubArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
        }
    }

    // solution using Deque
    public int maxUniqueNumSub(Deque dq){

        return 0;
    }
}