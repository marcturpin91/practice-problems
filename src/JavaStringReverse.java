/**
 * Created by Marc on 2016-11-18.
 */

import java.util.Scanner;

public class JavaStringReverse {

    /*
     A palindrome is a word, phrase, number, or other sequence of
     characters which reads the same backward or forward.(Wikipedia)

     Given a string A, print Yes if it is a palindrome, print No otherwise
     Constraints: A will consist at most 50 lower case english letters.
     */

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        // Given that a palindrome has matching letters at opposite indices, we can iterate through
        // the string using a loop at the charAt(int index) string method to check if inverse indices
        // are equal. Alternatively, we can transform it to a char array and iterate through that,
        // but it might come at the cost of more memory

        int stringLength = A.length();
        // For even length strings, this loop checks that all inverse characters match.
        // For odd length strings, this loop skips the middle element given that it will not
        // affect the results of the string being a palindrome or not.
        for(int i = 0; i < (stringLength/2); i++){
            if(A.charAt(i) != A.charAt(stringLength-i)){
                System.out.println("No");
                break;
            }
        }
        System.out.println("Yes");
    }

}
