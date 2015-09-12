/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        return swapPairs(head, head.next);
    }
    
    private ListNode swapPairs(ListNode pre, ListNode cur) {
        if(pre.next == null) {
            return pre;
        }
        if(cur.next == null) {
            cur.next = pre;
            pre.next = null;
            return cur;
        }
        pre.next = swapPairs(cur.next, cur.next.next);
        cur.next = pre;
        return cur;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre.next = next.next == null? next : next.next;
            pre = next;
            cur = next.next;
        }
        if(cur != null && cur.next == null) {
            pre.next = null;
            cur.next = pre;
        }
        return dummy.next;
    }
}