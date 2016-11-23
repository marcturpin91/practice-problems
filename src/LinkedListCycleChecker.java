/**
 * Created by Marc on 2016-11-22.
 */

/*
Context & Instructions:
Complete the function provided in the editor below. It has one parameter: a
pointer to a Node object named 'head' that points to the head of a linked list.
Your function must return a boolean denoting whether or not there is a cycle
in the list. If there is a cycle, return true; otherwise, return false.

Note: If the list is empty, head will be null.

Input Format:
Our hidden code checker passes the appropriate argument to your function.
You are not responsible for reading any input from stdin.

Output Format:
If the list contains a cycle, your function must return true. If the list
does not contain a cycle, it must return false. The binary integer
corresponding to the boolean value returned by your function is printed
to stdout by our hidden code checker.

LINK TO CHALLENGE:
https://www.hackerrank.com/challenges/ctci-linked-list-cycle
*/


/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}


public class LinkedListCycleChecker {


    boolean hasCycle(Node head) {
        // Complete this code for the challenge

        // case where head is null, or two ahead is null, indicates that there's no cycle.
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        } else {
            // puts one node ahead by two so it will catch up eventually if there is a cycle
            Node current = head;
            Node aheadCurrent = head.next.next;
            while (current.next != null && aheadCurrent.next.next != null) {
                if (current == aheadCurrent) {
                    return true;
                }
                current = current.next;
                aheadCurrent = aheadCurrent.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args){
        // we can test here but there are test cases already on the challenge website that has proven this
        // works and solves the challenge
    }


}