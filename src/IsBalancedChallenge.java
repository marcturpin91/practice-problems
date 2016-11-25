/**
 * Created by Marc on 2016-11-23.
 */

/*
Instructions and Context:
A matching pair of brackets is not balanced if the set of brackets it
encloses are not matched. For example, {[(])} is not balanced because the
contents in between { and } are not balanced. The pair of square brackets
encloses a single, unbalanced opening bracket, (, and the pair of
parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced
if the following conditions are met:

-It contains no unmatched brackets.
-The subset of brackets enclosed within the confines of a matched pair of
brackets is also a matched pair of brackets.

Given N strings of brackets, determine whether each sequence of brackets
is balanced. If a string is balanced, print YES on a new line;
otherwise, print NO on a new line.

Input Format:
The first line contains a single integer, N, denoting the number of strings.
Each line 'i' of the N subsequent lines consists of a single string, S,
denoting a sequence of brackets.

Output Format
For each string, print whether or not the string of brackets is balanced
on a new line. If the brackets are balanced, print YES; otherwise, print NO.

Input / Output Ex:
3
{[()]}
{[(])}
{{[[(())]]}}

YES
NO
YES
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IsBalancedChallenge {

    public static boolean isBalanced(String expression) {
        // checks 1st bit to see if it's uneven -- if it is, impossible to have balanced brackets
        if((expression.length() & 1) == 1)
            return false;

        Stack<Character> matchingBrackets = new Stack<>();
        for(char bracket : expression.toCharArray()) {
            switch (bracket) {
                case '[': matchingBrackets.add(']');
                    break;
                case '{': matchingBrackets.add('}');
                    break;
                case '(': matchingBrackets.add(')');
                    break;
                default:
                    if (matchingBrackets.isEmpty() || bracket != matchingBrackets.peek())
                        return false;
                    matchingBrackets.pop();
                    break;
            }
        }
        return matchingBrackets.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
