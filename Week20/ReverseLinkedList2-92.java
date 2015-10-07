/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //Draw the picture and check the corner case when list is one node and two node
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int pos = 1;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode start = dummy;
        while(pos < m) {
            if(pos + 1 == m) start = pre;
            pre = pre.next;
            cur = cur.next;
            pos++;
        }
        while(pos < n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            pos++;
        }
        start.next.next = cur;
        start.next = pre;
        return dummy.next;
    }
}