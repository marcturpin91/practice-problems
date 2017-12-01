/**
 * Created by Marc on 2017-11-28.
 */

import java.util.HashMap;


public class LLRemoveDups {
    /*
    Create function that removes dups from unsorted linked
     */

    public static void main(String[] args){
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node root = a;
        System.out.println("Original LL: ");
        printLL(root);

        System.out.println("Shouldn't remove any nodes: ");
        removeDups(root);
        printLL(root);

        b.value = 'a';
        d.value = 'c';

        System.out.println("Should be a,c,e: ");
        removeDups(root);
        printLL(root);


    }

    public static void printLL(Node root){
        while(root != null){
            System.out.println(root.value);
            root = root.next;
        }
    }

    public static void removeDups(Node root){
        HashMap<Character, Character> map = new HashMap<>();
        Node current = root;
        Node prev = null;
        while(current != null){
            // unique node, put in map
            if(!map.containsKey(current.value)){
                map.put(current.value, current.value);
                prev = current;
            }
            // duplicate, remove from LL
            else {
                prev.next = current.next;
            }
            current = current.next;
        }
    }

    public static class Node {
        public char value;
        public Node next;
        public Node(char val){
            this.value = val;
        }
    }
}
