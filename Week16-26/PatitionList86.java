/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // two pointer for linkedlist
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode walker = helper, runner = helper;
        while(runner.next != null) {
            if(runner.next.val < x) {
                if(walker != runner) {
                    ListNode next = runner.next.next;
                    runner.next.next = walker.next;
                    walker.next = runner.next;
                    runner.next = next;
                } else {
                    runner = runner.next;
                }
                // make sure that the qualified node is fixed in that place
                walker = walker.next;
            } else {
                runner = runner.next;
            }
        }
        return helper.next;
    }

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