/**
 * Created by Marc on 2016-11-18.
 */
import java.util.Scanner;
public class HourGlassSum{
    /*
    Instruction and Context:
    Given an array of 6*6, return the biggest 'hour glass' shaped sum.
    An hour glass is shaped by 3 rows, where the first and last row contain
    3 consecutive elements, and the middle row only 1 element in the middle.
    Ex: Here the 2's represent the only hour glass shape that is fully represented.
    The sum would be 14. It is important to note that all same shapes, even if they
    contain 0's, count as hour glasses.
    0 0 0 0 0 0
    1 1 1 2 2 2
    1 0 1 1 2 0
    1 1 0 2 2 2
    0 0 0 0 0 0
    1 1 1 1 1 1

    The supplied 6*6 array can contain more than one hour glass shape, thus we
    must return the highest sum hour glass.

    The supplied input will be integers ranging from -9 to 9 inclusively.
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(hourGlassSum(arr));
    }

    public static int hourGlassSum(int[][] arr){
        // constraints make it so the smallest sum we can get is 7*(-9) = -63, thus maxSum will get replaced by first sum
        int maxSum = -100;
        int tempSum = 0;
        // i = rows
        // j = columns
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                tempSum = 0;
                // top 3 of hour glass
                tempSum += arr[i][j];
                tempSum += arr[i][j+1];
                tempSum += arr[i][j+2];

                // middle part
                tempSum += arr[i+1][j+1];

                // bottom 3
                tempSum += arr[i+2][j];
                tempSum += arr[i+2][j+1];
                tempSum += arr[i+2][j+2];
                if (tempSum > maxSum){
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }
}