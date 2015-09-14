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
}