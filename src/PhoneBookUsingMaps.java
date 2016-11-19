/**
 * Created by Marc on 2016-11-19.
 */
import java.util.HashMap;
import java.util.Scanner;
public class PhoneBookUsingMaps{
    /*
    Context:
    You are given a phone book that consists of people's names and their
    phone number. After that you will be given some person's name as query.
    For each query, print the phone number of that person.

    Input format:
    The first line will have an integer N denoting the number of entries in the
    phone book. Each entry consists of two lines: a name and the corresponding
    phone number.
    After these, there will be some queries. Each query will contain a person's
    name. Read the queries until end-of-file.

    Constraints:
    A person's name consists of only lower-case English letters and it may be in
    the format 'first-name last-name' or in the format 'first-name'.
    Each phone number has exactly 8 consecutive digits without any leading zeros.

    Input / Output Sample:
    3
    uncle sam
    99912222
    tom
    11122222
    harry
    12299933
    uncle sam
    uncle tom
    harry

    uncle sam=99912222
    Not found
    harry=12299933
    */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<String, String>();
        int amountOfEntries = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < amountOfEntries; i++){
            phoneBook.put(sc.nextLine(), sc.nextLine());
        }
        while(sc.hasNext()){
            String query = sc.nextLine();
            if(phoneBook.containsKey(query)){
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }
        sc.close();
    }
}