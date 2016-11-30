/**
 * Created by Marc on 2016-11-30.
 */

/*
Context & Instructions:

Consider the following version of Bubble Sort:

for (int i = 0; i < n; i++) {
    // Track number of elements swapped during a single array traversal
    int numberOfSwaps = 0;

    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
            numberOfSwaps++;
        }
    }

    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps == 0) {
        break;
    }
}

Given an n-element array, A=a0, a1, ..., an-1, of distinct elements,
sort array A in ascending order using the Bubble Sort algorithm
above. Once sorted, print the following three lines:

1. Array is sorted in numSwaps swaps., where numSwaps is the number
of swaps that took place.
2. First Element: firstElement, where firstElement is the first
element in the sorted array.
3. Last Element: lastElement, where lastElement is the last
element in the sorted array.
Hint: To complete this challenge, you must add a variable that keeps
a running tally of all swaps that occur during execution.

Input Format:
The first line contains an integer, n, denoting the number of
elements in array A. The second line contains n space-separated
integers describing the respective values of a0, a1, ..., an-1.

Ex of Input/Output:
3
1 2 3

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3
*/

import java.io.*;
import java.util.*;

public class BubbleSortChallenge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    }
}