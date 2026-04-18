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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;

        list2 = reverseList(list2, null);

        mergeAlternatively(list1, list2);

    }

    private ListNode reverseList(ListNode curr, ListNode prev) {

        if(curr == null) {
            return null;
        }

        if(curr.next == null) {
            curr.next = prev;
            return curr;
        }

        ListNode head = reverseList(curr.next, curr);

        curr.next = prev;

        return head;
    }

    private void mergeAlternatively(ListNode l1, ListNode l2) {

        while(l1 != null && l2 != null) {
            ListNode f = l1;
            ListNode s = l2;

            l1 = l1.next;
            l2 = l2.next;

            f.next = s;
            s.next = l1;
        }
    }

    
}
