/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // no any easy way, time O(n), space O(1)
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
            if(cur.val == val) {
                ListNode next = cur.next;
                cur.next = null;
                pre.next = next;
                cur = next;
            }
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}