/**
 * Created by Marc on 2016-11-21.
 */

/*
Context & Instructions:
Given two strings, A and B, that may or may not be of the same length,
determine the minimum number of character deletions required to make A
and B anagrams. Any characters can be deleted from either of the strings.

Input Format:
The first line contains a single string, A.
The second line contains a single string, B.

Constraint:
It is guaranteed that A and B consist of lowercase English alphabetic
letters (i.e., a through z).

Output Format:
Print a single integer denoting the number of characters you must delete
to make the two strings anagrams of each other.

Input -> Output:
cde
abc
-> 4
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> characterSet = new HashMap<>();
        char currentChar;
        int currentAmount;
        for(int i = 0; i < first.length(); i++){
            currentChar = first.charAt(i);
            currentAmount = (characterSet.containsKey(currentChar)? characterSet.get(currentChar) : 0);
            characterSet.put(currentChar, currentAmount+1);
        }

        for(int j = 0; j < second.length(); j++){
            currentChar = second.charAt(j);
            currentAmount = (characterSet.containsKey(currentChar)? characterSet.get(currentChar) : 0);
            characterSet.put(currentChar, currentAmount-1);
        }

        int numberOfCharsToRemove = 0;
        for(int x : characterSet.values()){
            numberOfCharsToRemove += Math.abs(x);
        }
        return numberOfCharsToRemove;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
