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
        Node h = head;
        while (h != null) {
            Node currNext = h.next;
            Node clone = new Node(h.val);
            clone.next = currNext;
            h.next = clone;
            h = currNext;
        }

        h = head;
        while(h != null) {
            if(h.random != null) {
                h.next.random = h.random.next;
            }
            h = h.next.next;
        }

        Node dummyNode = new Node(9999);
        Node newHead = dummyNode;
        h = head;

        while(h != null) {
            Node clone = h.next;
            Node origNext = clone.next;

            dummyNode.next = clone;
            dummyNode = dummyNode.next;

            // Restore original list's pointer
            h.next = origNext;

            // Move to the next original node
            h = origNext;
        }

        return newHead.next;
    }
}
