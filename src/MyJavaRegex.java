/**
 * Created by Marc on 2016-11-18.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class MyJavaRegex{

    /*
    Context:
    Write a class called myRegex which will contain a string pattern.
    You need to write a regular expression and assign it to the pattern
    such that it can be used to validate an IP address. Use the following
    definition of an IP address:

    IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D
    may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D
    can't be greater than 3.

    Instruction:
    In this problem you will be provided strings containing any combination of ASCII
    characters. You have to write a regular expression to find the valid IPs.
    Just write the MyRegex class which contains a String . The string should contain
    the correct regular expression. (MyRegex class MUST NOT be public)

    Sample input -> output:
    000.12.12.034           -> true
    121.234.12.12           -> true
    23.45.12.56             -> true
    00.12.123.123123.123    -> false
    122.23                  -> false
    Hello.IP                -> false
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String IP = sc.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    // instructions told me to create this static inner class, I do not encourage this type of activity bahaha
     static class MyRegex{
        String range = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
         public String pattern = range + "." + range + "." + range + "." + range;
    }



}