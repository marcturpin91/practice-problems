/**
 * Created by Marc on 2016-12-02.
 */

/*
Context & Instructions:
Given an array of N Player objects, write a comparator that sorts them in
order of decreasing score; if 2 or more players have the same score, sort
those players alphabetically by name. To do this, you must create a Checker
class that implements the Comparator interface, then write an int
compare(Player a, Player b) method implementing the
Comparator.compare(T o1, T o2) method.

Input Format:
Locked stub code in the Solution class handles the following input from
stdin: The first line contains an integer, n, denoting the number of
players. Each of the n subsequent lines contains a player's respective
name and score.

Output Format:
You are not responsible for printing any output to stdout. Locked stub code
in Solution will create a Checker object, use it to sort the Player array,
and print each sorted element.

Constraints:
0 <= score <= 1000
Two or more players can have same name
Players names are lowercase English alphabetic letters

Sample I/O:
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/

import java.util.*;
// Write your Checker class here
class ScoreChecker implements Comparator<StudentPlayer>{
    public int compare(StudentPlayer a, StudentPlayer b){
        if(a.score != b.score){
            return b.score - a.score;
        }
        else if(a.name != b.name){
           return a.name.compareTo(b.name);
        }

        // case where they are equal in terms of score and name
        return 0;
    }
}



class StudentPlayer{
    String name;
    int score;

    StudentPlayer(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class ComparatorHRChallenge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        StudentPlayer[] player = new StudentPlayer[n];
        ScoreChecker checker = new ScoreChecker();

        for(int i = 0; i < n; i++){
            player[i] = new StudentPlayer(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}