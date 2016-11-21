/**
 * Created by Marc on 2016-11-21.
 */

/*
Context & Instructions:
You are given an interface AdvancedArithmetic which contains
a method signature int divisor_sum(int n). You need to write
a class called MyCalculator which implements the interface.

divisorSum function just takes an integer as input and return
the sum of all its divisors. For example divisors of 6 are 1,
2, 3 and 6, so divisor_sum should return 12. The value of n
will be at most 1000.

Read the partially completed code in the editor and complete
it. You just need to write the MyCalculator class only.
Your class shouldn't be public.

Sample Input & Output:
In -> 6
Out-> I Implemented: AdvancedArithmetic
12
*/

import java.util.*;
interface AdvancedArithmetic{
    int divisor_sum(int n);
}
//Write your code here
class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        int sumOfDivisors = 0;
        // won't waste time in loop going through things after halfway since it's imposible to be a divisor apart from itself
        int lastPosibleDivisor = n/2;
        // goes up to halfway
        for(int i = 1; i < lastPosibleDivisor+1; i++){
            if(n % i ==0){
                sumOfDivisors += i;
            }
        }
        // returns the result + itself since it is itself a divisor
        return sumOfDivisors+n;
    }
}


class DivisorSumInterface{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}