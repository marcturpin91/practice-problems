/**
 * Created by Marc on 2017-03-10.
 */

import java.io.*;
        import java.util.*;

public class NextLexicoStringChallenge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int numOfTestCases = sc.nextInt();
        String[] myAnswers = new String[numOfTestCases];
        String[] inputs = new String[numOfTestCases];
        sc.nextLine();

        for(int i = 0; i < numOfTestCases; i++){
            String input = sc.nextLine();
            inputs[i] = input;
            // System.out.println(nextLexicoString(input));
            myAnswers[i] = nextLexicoString(input);
        }

        String[] answers = new String[numOfTestCases];
        for(int i = 0; i < numOfTestCases; i++){
            String input = sc.nextLine();
            answers[i] = input;
        }

        for(int i = 0; i < numOfTestCases; i++){
            if((!myAnswers[i].equals(answers[i])) && answers[i].length() < 6){
                System.out.println("Input was: " + inputs[i]);
                System.out.println("My Answer: " + myAnswers[i]);
                System.out.println("Actual As: " + answers[i]);
                System.out.println();
            }
        }
    }

    public static String nextLexicoString(String input){
        // algorithm works by looking for smallest possible change
        // this implies going from right side to left, looking for first possible swap
        // swap when you find a letter on the right side that is bigger than a letter to its left, going from right to left
        // make sure the rest of the string on the right side of the index where the new bigger letter is, is sorted
        // if you end up on the 0 index and didn't conduct a swap, you return "no answer"
        char[] charInputArr = input.toCharArray();
        for(int i = charInputArr.length - 1; i > 0; i--){
            for(int j = (i - 1); j >= 0; j--){
                if(charInputArr[i] > charInputArr[j]){
                    swap(charInputArr, i, j);
                    Arrays.sort(charInputArr, j + 1, charInputArr.length);
                    return String.valueOf(charInputArr);
                }
            }
        }
        return "no answer";
    }

    public static void swap(char[] arr, int indexA, int indexB){
        char tempChar = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = tempChar;
    }
}