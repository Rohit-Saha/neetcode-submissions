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

        ListNode curr = head;

        while(curr != null) {
            len++;
            curr =curr.next;
        }

        int indexToDelete = len-n;

        int i=0;

        curr = head;
        ListNode prev = null;

        while(i<indexToDelete) {
            i++;
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
            curr.next = null;
        }

        

        return head;
    }
}
