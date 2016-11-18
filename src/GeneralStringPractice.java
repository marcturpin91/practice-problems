/**
 * Created by Marc on 2016-11-18.
 */
import java.util.Scanner;
public class GeneralStringPractice {
    /*
    Instructions:
    Given two strings of lowercase English letters, A and B, perform the following operations:
    1. Sum the lengths of A and B.
    2. Determine if A is lexicographically larger than B (i.e.: does B come before A in the dictionary?).
    3.Capitalize the first letter in A and B and print them on a single line, separated by a space.

    Constraints:
    The first line contains a string A. The second line contains another string B. The strings are
    comprised of only lowercase English letters.

    Sample input:
    hello
    java

    Sample output:
    9
    No
    Hello Java
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();

        // 1. Sum the lengths of A and B:
        System.out.println(a.length() + b.length());


        // 2. Determine if A is lexicographically larger than B (i.e.: does B come before A in the dictionary?):

        // if one string is a substring of the other starting at index 0
        // and ending before the total length of the other string, we will
        // deem that substring to be lexicographically smaller than the full
        // string.

        /* INITIAL SOLUTION:
        int minLength = a.length();
        if(a.length() != b.length()){
            minLength = (a.length() > b.length()? b.length() : a.length());
        }

        boolean isLexicographicallyBigger = true;
        for(int i = 0; i < minLength; i++){
            if(a.charAt(i) > b.charAt(i)){
                break;
            } else if (a.charAt(i) < b.charAt(i)){
                isLexicographicallyBigger = false;
            } else{
                // case where both chars are equal
                if(i == minLength && (b.length() > a.length())){
                    // case where all characters are equal from 0 to the length of the smallest string
                    // and where b is the longer string, b would be lexicographicallyBigger
                    isLexicographicallyBigger = false;
                }
            }
        }
        System.out.println(isLexicographicallyBigger? "Yes" : "No");
        */

        System.out.println(b.compareTo(a) < 0? "Yes" : "No");

        // 3.Capitalize the first letter in A and B and print them on a single line, separated by a space:
        System.out.println(a.substring(0, 1).toUpperCase() + a.substring(1) + " " + b.substring(0,1).toUpperCase() + b.substring(1));

    }
}
