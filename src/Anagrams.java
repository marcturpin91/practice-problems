/**
 * Created by Marc on 2016-11-18.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Anagrams {

    /*
    Context:
    Two strings A and B are called anagrams if they consist same characters, but may be
    in different orders. So the list of anagrams of CAT is ACT, ATC, CAT, CTA, TAC, TCA.

    Instruction:
    Given two strings, print 'Anagrams' if they are anagrams, print 'Not Anagrams' if they
    are not. The strings may consist at most 50 English characters; the comparison should
    NOT be case sensitive.

    Knowledge:
    This exercise will verify that you can sort the characters of a string, or compare
    frequencies of characters.
     */

    static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        char[] aCharsArray = a.toLowerCase().toCharArray();
        char[] bCharsArray = b.toLowerCase().toCharArray();

        Arrays.sort(aCharsArray);
        Arrays.sort(bCharsArray);

        for (int i = 0; i < aCharsArray.length; i++){
            if(aCharsArray[i] != bCharsArray[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();

        System.out.println((isAnagram(a,b)? "Anagrams" : "Not Anagrams"));
    }

}
