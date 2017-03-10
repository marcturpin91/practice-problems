/**
 * Created by Marc on 2017-03-09.
 */

/*
Problem Description:
Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits.

Input Format:
The first line contains an integer, T, which is the number of test cases. T test cases follow, each having a structure as described below:
The first line contains two space-separated integers, R and C, indicating the number of rows and columns in the grid G, respectively.
This is followed by R lines, each with a string of C digits, which represent the grid G.
The following line contains two space-separated integers, r and c, indicating the number of rows and columns in the pattern grid P.
This is followed by r lines, each with a string of c digits, which represent the pattern P.

Output Format:
Display 'YES' or 'NO', depending on whether (or not) you find that the larger grid G contains the rectangular pattern P. The evaluation will be case sensitive.

Sample Input:
2
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99

Sample Output:
YES
NO
 */

import java.util.*;

public class GridPatternMatchProblem {

    public static void main(String[] args) {
        // start of provided code
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            // end of provided code

            // solution
            System.out.println(patternMatch(G, P));
        }
    }

    public static String patternMatch(String[] graph, String[] pattern){
        int index = -1;
        for(int i = 0; i <= (graph.length - pattern.length); i++){
            index = (graph[i]).indexOf(pattern[0]);
            while(index != -1){

                if(fullMatch(graph, pattern, i, index)){
                    return "YES";
                }
                if(index < (graph[i].length() - 1)) {
                    index = (graph[i]).indexOf(pattern[0], index + 1);
                }
            }
        }
        return "NO";
    }

    public static boolean fullMatch(String[] graph, String[] pattern, int row, int index){
        for(int i = row, j = 0; i < (row + pattern.length); i++, j++){
            if(! ((graph[i]).substring(index, index + pattern[j].length())).equals(pattern[j])){
                return false;
            }
        }
        return true;
    }
}
