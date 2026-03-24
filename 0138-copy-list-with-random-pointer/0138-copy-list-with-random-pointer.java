/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

    // list is empty
        if (head == null)
            return null;

        // copy nodes
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;            // store next node
            curr.next = new Node(curr.val);   // create copy node
            curr.next.next = temp;            // link copy to next original
            curr = temp;                      // move to next original node
        }
        // original.random → some node
        // so copy.random = original.random.next
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // move to next original node
        }

       
        // separate original and copied lists

        Node orig = head;        // pointer for original list
        Node copy = head.next;   // pointer for copied list
        Node temp = copy;        // store head of copied list

        while (orig != null) {
            orig.next = orig.next.next; // restore original list

            if (copy.next != null) {
                copy.next = copy.next.next; // link copied nodes
            } else {
                copy.next = null;
            }

            orig = orig.next;   // move original pointer
            copy = copy.next;   // move copy pointer
        }

        // return head of copied list
        return temp;
    }
}