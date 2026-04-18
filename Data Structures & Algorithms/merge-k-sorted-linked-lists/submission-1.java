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
        ListNode head = null;

        for(ListNode l: lists) {
            head = mergeSortedLinkedList(head, l);
        }

        return head;
    }

    private ListNode mergeSortedLinkedList(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode curr = null;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                if(head == null) {
                    head = l1;
                    curr = l1;
                } else {
                    curr.next = l1;
                    curr = curr.next;
                }
                l1 = l1.next;
            } else {
                if(head == null) {
                    head = l2;
                    curr = l2;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                }
                l2 = l2.next;
            }
        }

        while(l1 != null) {
            if(head == null) {
                head = l1;
                curr = l1;
            } else {
                curr.next = l1;
                curr = curr.next;
            }
            l1 = l1.next;
        }

        while(l2 != null) {
            if(head == null) {
                head = l2;
                curr = l2;
            } else {
                curr.next = l2;
                curr = curr.next;
            }
            l2 = l2.next;
        }

        return head;
    }
}
