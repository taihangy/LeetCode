/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // time O(n), space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
            if(cur.val != index.val) {
                // line with new node
                index.next = cur;
                // cut duplicates
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

    // recursive method, from end to start, in every recursion, remain head and head.next
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}