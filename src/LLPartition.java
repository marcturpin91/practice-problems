/**
 * Created by Marc on 2017-11-30.
 */
public class LLPartition {
    /*
    partition LL around value x such that nodes that have a value less than x
    come before, and bigger valued nodes come after. If a node has value = x
    put it after nodes less than x. Does not need to be put in middle, as
    long as it is positioned to the right of the partition.
     */

    public static void main(String[] args){
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(5);
        Node e = new Node(10);
        Node f = new Node(2);
        Node g = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        printLL(a);
        System.out.println("Partitioning on value 5");
        partition(a, 5);
    }

    // ex: input:  1->5->3->10->8, 5
    // ex: output: 1->3->5->10->8
    public static Node partition(Node root, int x){
        if(root == null || root.next == null) return null;

        Node current = root;
        Node lRoot = null; // set only once at first node smaller
        Node currentL = null; // current node in smaller list
        Node bRoot = null; // set only once at first node bigger
        Node currentB = null; // current node in bigger list

        while(current != null){

            // lowerNodes
            if(current.value < x){
                if(lRoot == null){
                    lRoot = current;
                    currentL = current;
                }
                else{
                    currentL.next = current;
                    currentL = currentL.next;
                }
            }
            // biggerNodes (or equal)
            else{
                if(bRoot == null){
                    bRoot = current;
                    currentB = current;
                }
                else{
                    currentB.next = current;
                    currentB = currentB.next;
                }
            }

            current = current.next;
        }

        // joins two list together
        currentL.next = bRoot;
        currentB.next = null;
        System.out.println("Printing joined list: ");
        printLL(lRoot);
        return lRoot;
    }


    public static void printLL(Node root){
        while(root != null){
            System.out.println(root.value);
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
