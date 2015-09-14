/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // one pass, time O(n), space O(1)
        if(head == null || head.next == null) return null;
        // solve remove head problem
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy;
        ListNode runner = dummy;
        int count = 0;
        while(count < n) {
            count++;
            runner = runner.next;
        }
        while(runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        walker.next = walker.next.next;
        return dummy.next;
    }
}