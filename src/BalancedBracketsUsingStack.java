/**
 * Created by Marc on 2016-11-19.
 */
import java.util.Scanner;
import java.util.Stack;
public class BalancedBracketsUsingStack{

/*
Context & Instructions:
A string containing only parentheses is balanced if the following is true:
1. if it is an empty string
2. if A and B are correct, AB is correct,
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input / Output:
There will be multiple lines in the input file, each having a single
non-empty string. You should read input till end-of-file.

ex:
{}()
({()})
{}(
[]

Output 'true' or 'false' if they are balanced or not.
*/

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    while(sc.hasNext()){
        Stack<Character> balancedOrNotStack = new Stack<Character>();
        boolean isBalanced = true;
        String brackets = sc.nextLine();
        char[] individualBrackets = brackets.toCharArray();
        if(individualBrackets.length % 2 != 0){
            isBalanced = false;
        }

        // Goes through string, adds left brackets. When it encounters right bracket, pop the stack to see if they are
        // part of a balanced set. If not, set boolean to false.
        for(int i = 0; i < individualBrackets.length && isBalanced; i++){
            if(individualBrackets[i] == '{' || individualBrackets[i] == '(' || individualBrackets[i] == '['){
                balancedOrNotStack.push(individualBrackets[i]);
            } else if (individualBrackets[i] == '}' && (!balancedOrNotStack.isEmpty())){
                if(balancedOrNotStack.pop() != '{'){
                    isBalanced = false;
                }
            } else if (individualBrackets[i] == ')' && !(balancedOrNotStack.isEmpty())){
                if(balancedOrNotStack.pop() != '('){
                    isBalanced = false;
                }
            } else if (individualBrackets[i] == ']' && !(balancedOrNotStack.isEmpty())){
                if(balancedOrNotStack.pop() != '['){
                    isBalanced = false;
                }
            }
            // case where stack is empty
            else {
                isBalanced = false;
            }
        }
        System.out.println(isBalanced? "true" : "false");
    }

    sc.close();
}
}