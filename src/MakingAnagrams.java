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
        HashMap<Character, Integer> smallerSet = new HashMap<>();
        int numberOfCharsToRemove = 0;
        char currentChar;
        String smallerString = (first.length() <= second.length() ? first : second);
        String biggerString = (first.length() > second.length() ? first : second);
            for (int i = 0; i < smallerString.length(); i++) {
                currentChar = smallerString.charAt(i);
                if (smallerSet.containsKey(currentChar)) {
                    smallerSet.put(currentChar, smallerSet.get(currentChar) + 1);
                } else {
                    smallerSet.put(currentChar, 1);
                }
            }
            // going through bigger string
            for(int j = 0; j < biggerString.length(); j++){
                currentChar = biggerString.charAt(j);
                // if character is not in set, that equates to another char we need to remove to be an anagram
                if(!smallerSet.containsKey(currentChar)){
                    numberOfCharsToRemove++;
                } else {
                    // these two conditions will essentially remove matching characters
                    if(smallerSet.get(currentChar) > 1){
                        smallerSet.put(currentChar, smallerSet.get(currentChar)-1);
                    } else {
                        smallerSet.remove(currentChar);
                    }
                }

        }
        // adds remaining unique characters from smaller set
        for(int x : smallerSet.values()){
            numberOfCharsToRemove += x;
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
