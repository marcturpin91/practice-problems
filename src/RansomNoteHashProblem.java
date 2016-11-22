/**
 * Created by Marc on 2016-11-22.
 */

/*
Context & Instructions:
A kidnapper wrote a ransom note but is worried it will be traced back to
him. He found a magazine and wants to know if he can cut out whole words
from it and use them to create an untraceable replica of his ransom note.
The words in his note are case-sensitive and he must use whole words
available in the magazine, meaning he cannot use substrings or
concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print
Yes if he can replicate his ransom note exactly using whole words from
the magazine; otherwise, print No.

Input Format:
The first line contains two space-separated integers describing the
respective values of M (the number of words in the magazine) and N
(the number of words in the ransom note).
The second line contains M space-separated strings denoting the words
present in the magazine.
The third line contains N space-separated strings denoting the words
present in the ransom note.

Output Format:
Print Yes if he can use the magazine to create an untraceable replica of
his ransom note; otherwise, print No.

Constraints:
1 <= M, N <= 30,000
1 <= length of any word <= 5
Each word consists of English alphabetic letters (i.e., a, A to z, Z)
The words in the note and magazine are case-sensitive.

Input / Output Sample:
6 4
give me one grand today night
give one grand today

Yes
*/

import java.util.*;

public class RansomNoteHashProblem {
    Map<String, Integer> magazineMap = new HashMap<>();
    Map<String, Integer> noteMap = new HashMap<>();

    public RansomNoteHashProblem(String magazine, String note) {
        int count = 0;
        for(String word : magazine.split(" ")){
           count = magazineMap.containsKey(word)? magazineMap.get(word) : 0;
            magazineMap.put(word, count + 1);
        }
        for(String word : note.split(" ")){
            count = noteMap.containsKey(word)? noteMap.get(word) : 0;
            noteMap.put(word, count + 1);
        }
    }

    public boolean solve() {
        for(String noteWord : noteMap.keySet()){
            // for each word in the note, if it is not contained in the magazine or it has more occurence than in magazine, return false
            if( (!magazineMap.containsKey(noteWord)) ||(magazineMap.get(noteWord) < noteMap.get(noteWord)) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNoteHashProblem solution = new RansomNoteHashProblem(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = solution.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
