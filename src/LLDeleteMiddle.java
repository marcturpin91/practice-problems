/**
 * Created by Marc on 2017-11-30.
 */
public class LLDeleteMiddle {


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

        printLL(a);
        deleteMiddle(c);
        printLL(a);

    }

    public static void deleteMiddle(Node x){
        if(x == null || x.next == null) return;
        System.out.println("Removing node " + x.value);
        x.value = x.next.value;
        x.next = x.next.next;
    }


    public static void printLL(Node root){
        while(root != null){
            System.out.println(root.value);
            root = root.next;
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
