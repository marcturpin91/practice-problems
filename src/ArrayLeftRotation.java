/**
 * Created by Marc on 2016-11-21.
 */

/*
Context & Instructions:
A left rotation operation on an array of size N shifts each of the array's
elements 1 unit to the left. For example, if 2 left rotations are performed
on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

Given an array of N integers and a number, D, perform D left rotations on
the array. Then print the updated array as a single line of
space-separated integers.

Input Format:
The first line contains two space-separated integers denoting the respective
values of N (the number of integers) and  D(the number of left rotations
you must perform).
The second line contains N space-separated integers describing the respective
elements of the array's initial state.
Sample input:
5 4
1 2 3 4 5

Output Format:
Print a single line of N space-separated integers denoting the final state
of the array after performing D left rotations.
Sample output:
5 1 2 3 4

Constraints:
1 <= n <= 10^5
1 <= d <= n
1 <= Ai <= 10^6
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        // write solution here:
        int[] shiftedArray = new int[n];
        int newPosition = 0;
        for(int i = 0; i < n; i++){
            newPosition = (i-k) >= 0 ? (i-k) : (n + (i-k));
            shiftedArray[newPosition] = a[i];
        }
        return shiftedArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
