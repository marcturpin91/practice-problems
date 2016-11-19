/**
 * Created by Marc on 2016-11-19.
 */
import java.util.Scanner;
import java.util.HashSet;
public class UniquePairsUsingHashSets{

    /*
    Context:
    You are given N pairs of strings. Two pairs (a,b) and (c,d) are identical
    if a=c and b=d. That also implies (a,b) is not same as (b,a). After taking
    each pair as input, you need to print number of unique pairs you currently have.
    Complete the code in the editor to solve this problem.

    Input format:
    In the first line, there will be an integer T denoting number of pairs.
    Each of the next T lines will contain two strings separated by a single space.

    Output:
    Print T lines indicating at each one of them the amount of unique pairs
    at that point.
    */

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        HashSet<String> uniqueNames = new HashSet<>();
//        int numOfUniquePairs = 0;
//        int numOfPairsToScan = sc.nextInt();
//        sc.nextLine();
//
//        for(int i = 0; i < numOfPairsToScan; i++){
//            if(uniqueNames.add(sc.nextLine())){
//                numOfUniquePairs++;
//            }
//            System.out.println(numOfUniquePairs);
//        }
//        sc.close();

        /* HackerRank forces you to use half their already impemented code
        * for this problem, thus I had to comment out initial solution */

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        // start solution here:
        HashSet<String> uniquePairs = new HashSet<>();
        for(int i = 0; i < t; i++){
            String concatenatedPair = pair_left[i] + " " + pair_right[i];
            uniquePairs.add(concatenatedPair);
            System.out.println(uniquePairs.size());
        }
    }

}