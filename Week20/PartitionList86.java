/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(cur.next != null) {
            ListNode next = cur.next;
            if(next.val >= x) {
                cur = next;
            }
            else {
                if(cur != pre) {
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    pre = pre.next;
                } else {
                    pre = pre.next;
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }
}