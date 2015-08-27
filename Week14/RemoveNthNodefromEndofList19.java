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
        // while remove head, set head to new head
        if(walker.next == head) {
            head = walker.next.next;
        }
        // remove Nth Node
        ListNode temp = walker.next.next;
        walker.next.next = null;
        walker.next = temp;
        return head;
    }
}