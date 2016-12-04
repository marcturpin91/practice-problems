/**
 * Created by Marc on 2016-12-03.
 */

/*
Context & Instructions:
Consider a matrix with n rows and m columns, where each cell contains
either a 0 or a 1 and any cell containing a 1 is called a filled cell. Two
cells are said to be connected if they are adjacent to each other
horizontally, vertically, or diagonally.

If one or more filled cells are also connected, they form a region. Note
that each cell in a region is connected to at least one other cell in the
region but is not necessarily directly connected to all the other cells
in the region.

Given an n x m matrix, find and print the number of cells in the largest
region in the matrix. Note that there may be more than one region in the
matrix.

Input Format:
The first line contains an integer, n, denoting the number of rows in the
matrix. The second line contains an integer, m, denoting the number of
columns in the matrix. Each line i of the n subsequent lines contains m
space-separated integers describing the respective values filling each
row in the matrix.

Output Format:
Print the number of cells in the largest region in the given matrix.

Constraints:
0 < n, m < 10

Sample I/O:
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

5
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class ConnectedCellsInGridChallenge {
    // self-notes: using dfs, add visited flag and go to each subsequent 1 that is in the same region.
    // need to figure out a way to not make too many calls or redundancies. If already visited, then don't add and don't go
    // if not visited, which one do you go to? Add to a stack next to visit? Like a real DFS?
    // Use a maxCount and regionCount variable.

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int row = in.nextInt();
            int column = in.nextInt();
            int grid[][] = new int[row][column];
            for(int grid_i=0; grid_i < row; grid_i++){
                for(int grid_j=0; grid_j < column; grid_j++){
                    grid[grid_i][grid_j] = in.nextInt();
                }
            }

            // My Solution:
            Stack<Integer> nextRowToVisit = new Stack<>();
            Stack<Integer> nextColToVisit = new Stack<>();
            int currentCount = 0;
            int maxCount = 0;

            // goes through every cell in the grid
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){

                    if(grid[i][j] == 1){
                        nextRowToVisit.push(i);
                        nextColToVisit.push(j);
                        grid[i][j] = -1;
                        currentCount = 1;

                        while(!nextRowToVisit.isEmpty()){
                            int currentRow = nextRowToVisit.pop();
                            int currentCol = nextColToVisit.pop();

                            // loop that checks all surrounding positions to see if there is a linking cell
                            for(int k = currentRow - 1; k <= currentRow + 1; k++){
                                for(int h = currentCol - 1; h <= currentCol + 1; h++){
                                    if(k >= 0 && h >= 0 && k < row && h < column){
                                        if(grid[k][h] == 1){
                                            grid[k][h] = -1;
                                            currentCount++;
                                            nextRowToVisit.push(k);
                                            nextColToVisit.push(h);
                                        }
                                    }
                                }
                            }
                        }
                        maxCount = (currentCount > maxCount? currentCount : maxCount);
                    }
                }
            }

            System.out.println(maxCount);
        }

}
