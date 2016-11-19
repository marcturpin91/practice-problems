/**
 * Created by Marc on 2016-11-18.
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ArrayListPracticeProblem{

    /*
    Context:
    You are given N lines. In each line there are zero or more integers.
    You need to answer a few queries where you need to tell the number
    located in Yth position of Xth line.
    Take input from System.in

    Input format:
    The first line has an integer N. In each of the next N lines there will
    be an integer D denoting number of integers on that line and then there
    will be D space-separated integers. In the next line there will be an
    integer Q denoting number of queries. Each query will consist of
    two integers X and Y.

    Constraints:
    1 <= N <= 20,000
    0 <= D <= 50,000
    1 <= Q <= 1,000
    1 <= X <= N
    ** Each number will fit in signed integer.
    * Total number of integers in  lines will not cross 100000.

    Output format:
    In each line, output the number located in Yth position of Xth line. If there
    is no such position, just print "ERROR!"

   Sample Input/Output:
   5
   5 41 77 74 22 44
   1 12
   4 37 34 36 52
   0
   3 20 22 33
   5
   1 3
   3 4
   3 1
   4 3
   5 5

   Output:
   74
   52
   37
   ERROR!
   ERROR!
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // first line and int is amount of lists
        ArrayList list = new ArrayList();
        int amountOfArrays = sc.nextInt();
        sc.nextLine(); // jumps to second line
        // outer loop is arrays
        for(int i = 0; i < amountOfArrays; i++){

            // inner loop is for elements in an array
            int numOfElements = sc.nextInt();
            list.add(i, new int[numOfElements]);
            for(int j = 0; j < numOfElements; j++){
                ((int[])list.get(i))[j] = sc.nextInt();
            }
            sc.nextLine(); // skips to next line after consuming every int for an array
        }

        int numOfQueries = sc.nextInt();
        sc.nextLine(); // jumps to nextline, the start of the queries
        for(int k = 0; k < numOfQueries; k++){
            int arrayX = sc.nextInt();
            int elementY = sc.nextInt();
            try{
                System.out.println(((int[])list.get(arrayX-1))[elementY-1]);
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ERROR!");
            }
            sc.nextLine(); // jumps to next line of queries
        }

    }

}