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
        for(int i=0; i<lists.length; i++) {
            head = mergeLinkedList(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeLinkedList(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode curr = null;

        while(l1 != null && l2 != null) {
            ListNode node = null;
            if(l1.val <= l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            if(newHead == null) {
                newHead = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            curr.next = null;

        }

        while(l1 != null) {
            if(newHead == null) {
                newHead = l1;
                curr = l1;
            } else {
                curr.next = l1;
                curr = curr.next;
            }
            
            l1 = l1.next;
            curr.next = null;
        }

        while(l2 != null) {
            if(newHead == null) {
                newHead = l2;
                curr = l2;
            } else {
                curr.next = l2;
                curr = curr.next;
            }
            
            l2 = l2.next;
            curr.next = null;
        }
        return newHead;
    }

}
