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
        Stack<Character> leftBrackets = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
                char singleBracket = expression.charAt(i);
                char poppedChar;
                switch (singleBracket){
                    case '[':
                        leftBrackets.add(singleBracket);
                        break;
                    case '{':
                        leftBrackets.add(singleBracket);
                        break;
                    case '(':
                        leftBrackets.add(singleBracket);
                        break;
                    case ']':
                        if(leftBrackets.isEmpty())
                            return false;
                       poppedChar = leftBrackets.pop();
                        if(poppedChar != '[')
                            return false;
                        break;
                    case '}':
                        if(leftBrackets.isEmpty())
                            return false;
                        poppedChar = leftBrackets.pop();
                        if(poppedChar != '{')
                            return false;
                        break;
                    case ')':
                        if(leftBrackets.isEmpty())
                            return false;
                        poppedChar = leftBrackets.pop();
                        if(poppedChar != '(')
                            return false;
                        break;
                    default:
                        return false;
                }
            }
        return leftBrackets.isEmpty();
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
