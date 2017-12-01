/**
 * Created by Marc on 2017-11-28.
 */
public class LLReturnKthLast {
    /*
    implement function that returns kth to last element in singly linked list
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

        Node testE = kthToLastNode(root, 0);
        System.out.println("Should print e");
        System.out.println(testE.value);

        Node testD = kthToLastNode(root, 1);
        System.out.println("Should print d");
        System.out.println(testD.value);


        Node testA = kthToLastNode(root, 4);
        System.out.println("Should print a");
        System.out.println(testA.value);

        Node testOver = kthToLastNode(root, 6);
        System.out.println("Should print a");
        System.out.println(testOver.value);
    }

    // using a runner ahead by n amount of nodes, we can solve this
    public static Node kthToLastNode(Node root, int n){
        if(root == null) return null;

        Node runner = root;
        while(n > 0 && runner.next != null){
            runner = runner.next;
            n--;
        }

        Node kth = root;
        while(runner.next != null){
            runner = runner.next;
            kth = kth.next;
        }

        return kth;
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
