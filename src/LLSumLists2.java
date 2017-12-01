/**
 * Created by Marc on 2017-11-30.
 */
public class LLSumLists2 {

    /*
    Given two lists that represent a number in reverse order,
    each node containing a single digit, add them together
    and return the answer in reverse order as well
    Ex: input: List 1 (0 -> 5 -> 2), List 2 (5 -> 7)
    Ex: operation: 250 + 75 = 325
    Ex: output: Answer (5 -> 2 -> 3)
     */

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(1);
        Node c = new Node(6);

        Node d = new Node(5);
        Node e = new Node(9);
        Node f = new Node(2);

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

        printLL(sumTwoReverse(a, d, 0));
    }

    /*
    Ex:
    input: List 1 (0 -> 5 -> 2), List 2 (5 -> 7)
    operation: 250 + 75 = 325
    output: Answer (5 -> 2 -> 3)
    */
    public static Node sumTwoReverse(Node list1, Node list2, int carry){
        if(list1 == null && list2 == null && carry == 0) return null;

        Node result = new Node(0);
        int partialSum = carry;

        if(list1 != null) partialSum += list1.value;
        if(list2 != null) partialSum += list2.value;

        result.value = partialSum % 10;

        // still operations to do, recurse
        if(list1 != null || list2 != null){
            Node next = sumTwoReverse(list1 == null? null : list1.next, list2 == null? null : list2.next, partialSum >= 10? 1 : 0);
            result.next = next;
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
