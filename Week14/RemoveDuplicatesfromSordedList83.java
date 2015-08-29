/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
            if(cur.val != index.val) {
                index.next = cur;
                if(pre != index) {
                    pre.next = null;
                }
                index = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        index.next = null;
        return dummy.next;
    }
}