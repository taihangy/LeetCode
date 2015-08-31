/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return reverseList(head, null);
    }
    private ListNode reverseList(ListNode cur, ListNode pre) {
        if(cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList(next, cur);
    }
}