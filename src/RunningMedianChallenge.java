/**
 * Created by Marc on 2016-11-26.
 */
/*
Context & Instructions:
Given an input stream of n integers, you must perform the following task
for each i-th integer:
1. Add the i-th integer to a running list of integers.
2. Find the median of the updated list (i.e., for the first element
through the i-th element).
3. Print the list's updated median on a new line. The printed value must
be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).

Input Format:
The first line contains a single integer, n, denoting the number of
integers in the data stream. Each line i of the n subsequent lines contains
an integer, Ai, to be added to your list.

Output Format:
After each new integer is added to the list, print the list's updated
median on a new line as a single double-precision number scaled to 1
decimal place (i.e., 12.3 format).

Constraints:
1 <= n <= 10^5
0 <= Ai <= 10^5

Input/Output Sample:
6
12  -> 12.0
4   -> 8.0
5   -> 5.0
3   -> 4.5
8   -> 5.0
7   -> 6.0
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedianChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
    }
}
