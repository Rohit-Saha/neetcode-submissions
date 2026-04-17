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
        if(head.next == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        System.out.println("middle::"+middle.val);
        ListNode seccond = middle.next;
        middle.next = null;
        seccond = reverseList(seccond, null);
        
        System.out.println("seccond head::"+seccond.val);
        ListNode first = head;
        ListNode sec = seccond;
        
        ListNode newHead = null;

        while(first != null && sec != null) {
            ListNode fNext = first.next;
            ListNode sNext = sec.next;
            if(newHead == null) {
                newHead = first;
                newHead.next = sec;
            } else {
                newHead.next = first;
                newHead.next.next = sec;
            }

            newHead = sec;

            first = fNext;
            sec = sNext;
        }

        if(first!=null) {
            newHead.next = first;
        }
 
        

    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if(head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        return reverseList(next, prev);

    }
}
