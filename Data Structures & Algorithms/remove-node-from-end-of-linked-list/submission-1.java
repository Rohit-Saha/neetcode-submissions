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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;

        ListNode t = head;

        while(t != null) {
            t = t.next;
            len++;
        }
        ListNode prev = null;
        ListNode curr = head;
        for(int i=0; i<len-n; i++) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;

        return head;
    }
}
