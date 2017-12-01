/**
 * Created by Marc on 2017-11-30.
 */
public class LLSumLists {

    /*
    Given two lists that represent a number in reverse order,
    each node containing a single digit, add them together
    and return the answer in reverse order as well
    Ex: input: List 1 (0 -> 5 -> 2), List 2 (5 -> 7)
    Ex: operation: 250 + 75 = 325
    Ex: output: Answer (5 -> 2 -> 3)
     */

    public static void main(String[] args) {
        Node a = new Node(9);
        Node b = new Node(7);
        Node c = new Node(8);

        Node d = new Node(6);
        Node e = new Node(8);
        Node f = new Node(5);

        // list 1
        a.next = b;
        b.next = c;
        System.out.println("List 1: ");
        printLL(a);

        // list 2
        d.next = e;
        e.next = f;
        System.out.println("\nList 2: ");
        printLL(d);
        System.out.println();

        printLL(sumTwoReverse(c, f));
    }

    /*
    Ex:
    input: List 1 (0 -> 5 -> 2), List 2 (5 -> 7)
    operation: 250 + 75 = 325
    output: Answer (5 -> 2 -> 3)
    */
    public static Node sumTwoReverse(Node list1, Node list2){
        if(list1 == null || list2 == null) return null;

        int num1 = 0;
        for(int i = 1; list1 != null; i *= 10){
            num1 += (i * list1.value);
            list1 = list1.next;
        }
        System.out.println("Number 1 = " + num1);

        int num2 = 0;
        for(int i = 1; list2 != null; i *= 10){
            num2 += (i * list2.value);
            list2 = list2.next;
        }
        System.out.println("Number 2 = " + num2);


        String sum = String.valueOf((num1 + num2));
        System.out.println("Result = " + sum);
        Node result = new Node(Character.getNumericValue(sum.charAt(sum.length()-1)));
        Node current = result;
        for(int i = sum.length()-2; i >=0; i--){
            current.next = new Node(Character.getNumericValue(sum.charAt(i)));
            current = current.next;
        }

        return result;
    }


    public static void printLL(Node root){
        while(root != null){
            System.out.print(root.value + " -> ");
            root = root.next;
        }
    }


    public static class Node {
        public int value;
        public Node next;
        public Node(int val){
            this.value = val;
        }
    }
}
