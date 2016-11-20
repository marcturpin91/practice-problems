/**
 * Created by Marc on 2016-11-19.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
/*
Context:
The Player class is provided for you in your editor.
It has 2 fields: a name String and a score integer.

Given an array of N Player objects, write a comparator that
sorts them in order of decreasing score; if 2 or more players
have the same score, sort those players alphabetically by name.
To do this, you must create a Checker class that implements the
Comparator interface, then write an int compare(Player a, Player b)
method implementing the Comparator.compare(T o1, T o2) method.

Input format:
Input from stdin is handled by the provided code for this problem.
The first line contains an integer, N, denoting the number
of players. Each of the N subsequent lines contains a player's
name and score, respectively.

Output:
You are not responsible for printing any output to stdout.
The locked stub code in Solution will create a Checker object,
use it to sort the Player array, and print each sorted element.

Constraints:
0 <= score <= 1000
2 players can have same name
player names consist of lowercase English letters

Input:
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

Output:
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/

// Write your Checker class here
class Checker implements Comparator<Player>{
    // comparing left object to right object will sort by increasing order, right to left will sort by decreasing
    public int compare(Player a, Player b){
        if(b.score == a.score){
            return (a.name.compareTo(b.name)); // in ascending order for names if they are equal score i.e. alex before bob
        } else{
            return b.score - a.score; // decreasing order for scores i.e. 150 before 100
        }
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class PlayerScoreComparable {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
