/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
    
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the link to prevent infinite cycles
        if(prev != null)
            prev.next = null;

        ListNode newMid = reverseList(slow);
        ListNode start = head;

        while(start != null && newMid != null) {
            ListNode pointerToNext1 = start.next;
            ListNode pointerToNext2 = newMid.next;

            start.next = newMid;
            // If pointerToNext1 is null, it means we reached the end of the first half
            if (pointerToNext1 == null)
                break; 
            
            newMid.next = pointerToNext1;

            start = pointerToNext1;
            newMid = pointerToNext2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }
}
