/**
 * Created by Marc on 2016-11-25.
 */
/*
Context & Instructions:
In this challenge, you must first implement a queue using two stacks.
Then process  queries, where each query is one of the following 3 types:
1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.

Input Format:
The first line contains a single integer, q, denoting the number of queries.
Each line i of the q subsequent lines contains a single query in the form
described in the problem statement above. All three queries start with an
integer denoting the query type, but only query 1 is followed by an
additional space-separated value, x, denoting the value to be enqueued.

Output Format:
For each query of type 3, print the value of the element at the front of
the queue on a new line.

Constraints:
1 <= q <= 10^5
1 <= type <= 3
1 <= |x| <= 10^9
It is guaranteed that a valid answer always exists for each query of type 3.

Sample Input / Output:
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2

14
14
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueuesUsingStackChallenge {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackOldestOnTop.push(value);
        }

        public T peek() {
            if(stackNewestOnTop.isEmpty() && !stackOldestOnTop.isEmpty()){
                while(!stackOldestOnTop.isEmpty()){
                    // reverses order and fills newestontop stack
                    stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            return stackNewestOnTop.peek();
        }

        public T dequeue() {
            if(stackNewestOnTop.isEmpty()){
                while(!stackOldestOnTop.isEmpty()){
                    // reverses order so it acts like a queue
                    stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            if(!stackNewestOnTop.isEmpty()){
                return stackNewestOnTop.pop();
            } else {
                return null;
            }
        }
    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
