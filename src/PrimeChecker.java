/**
 * Created by Marc on 2016-11-21.
 */

/*
Context & Instructions:
You are given a class Solution and its main method in the
editor. Your task is to create a class Prime. The class
Prime should contain a single method checkPrime.

The locked code in the editor will call the checkPrime method
with one or more integer arguments. You should write the
checkPrime method in such a way that the code prints only
the prime numbers.

Please read the code given in the editor carefully.
Also please do not use method overloading!

Note: You may get a compile time error in this problem due
to the statement below:
BufferedReader br=new BufferedReader(new InputStreamReader(in));
This was added intentionally, and you have to figure out
a way to get rid of the error.

Input:
There are only five lines of input, each containing one integer.

Output:
There will be only four lines of output. Each line contains
only prime numbers depending upon the parameters passed to
checkPrime in the main method of the class Solution.
In case there is no prime number, then a blank line should
be printed.

Input -> Output:
2 -> 2
1 -> 2
3 -> 2, 3
4 ->
5 -> 2, 3, 5
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

// Write solution here
import static java.lang.System.in;
class Prime{
    public void checkPrime(int... args){
        for(int x : args){
            if(isPrime(x)){
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int x){
        if(x <= 1){
            return false;
        }
        boolean isPrime = true;
        int halfway = x/2;
        for(int i = 2; i <= halfway; i++){
            if(x % i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }
}


// Provided code to work with:
public class PrimeChecker {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
