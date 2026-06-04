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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists[0] == null)
            return null; 

        ArrayList<Integer> arr = new ArrayList<>();
        for(ListNode list : lists) {
            while(list != null) {
                arr.add(list.val);
                list = list.next;
            }
        }

        int[] a = arr.stream()
                     .mapToInt(Integer :: intValue)
                     .toArray();

        Arrays.sort(a);

        ListNode dummy = new ListNode(100000);
        ListNode head = dummy;

        for(int n : a) {
            head.next = new ListNode(n);
            head = head.next;
        }

        return dummy.next;
    }
}
