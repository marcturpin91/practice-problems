/**
 * Created by Marc on 2016-11-23.
 */

/*
Context & Instructions:
We're going to make our own Contacts application! The application must
perform two types of operations:

1. add name, where 'name' is a string denoting a contact name. This must
store name as a new contact in the application.
2. find partial, where 'partial' is a string denoting a partial name to
search the application for. It must count the number of contacts
starting with  and print the count on a new line.

Given N sequential add and find operations, perform each operation in order.

Input Format:
The first line contains a single integer, N, denoting the number of
operations to perform. Each line 'i' of the N subsequent lines contains
an operation in one of the two forms defined above.

Output Format:
For each find partial operation, print the number of contact names
starting with partial on a new line.

Constraints:
1 <= N <= 10^5
1 <= |name| <= 21
1 <= |partial| <= 21
-It is guaranteed that name and partial contain lowercase English
letters only.
-The input doesn't have any duplicate name for the add operation.

Input / Output Example:
4
add hack
add hackerrank
find hac
find hak

2
0
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ContactsAppChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
        }
    }
}
