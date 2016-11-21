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

import java.util.HashMap;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class MaxUniqueNumbersSubArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashMap<Integer, Integer> setOfNumbers = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxUniqueNums = 0;

        // if  maxUniqueNums == m, break and print maxNum since we have reached max possible size
        for(int i = 0; i < n && maxUniqueNums < m; i++){
            int num = sc.nextInt();
            if(setOfNumbers.get(num) == null){
                setOfNumbers.put(num, 1);
            } else{
                setOfNumbers.put(num, setOfNumbers.get(num)+1);
            }

            // since we are at the size M of the subarray at this point ( i >= m )
            // we start popping at each iteration before adding a new num in to keep size m
            if(i >= m){

                // here we are checking if the element we are 'popping' was unique to the deque
                // if it was, we remove it from our hashmap to reflect the proper size of unique numbers
                int poppedNum = (int)deque.pop();
                int occurences = setOfNumbers.get(poppedNum);
                if(occurences > 1){
                    setOfNumbers.put(poppedNum, occurences-1);
                } else{
                    setOfNumbers.remove(poppedNum);
                }
            }
            // finally, add num whether it is unique or not, to keep size m of the deque
            deque.add(num);
            // at the end of the iteration, update maxUniqueNums if needed
            if(setOfNumbers.size() > maxUniqueNums){
                maxUniqueNums = setOfNumbers.size();
            }
        }
        System.out.println(maxUniqueNums);
    }
}