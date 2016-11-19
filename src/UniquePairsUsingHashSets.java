/**
 * Created by Marc on 2016-11-19.
 */
import java.util.Scanner;
import java.util.HashSet;
public class UniquePairsUsingHashSets{

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