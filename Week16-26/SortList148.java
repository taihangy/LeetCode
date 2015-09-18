/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // merge sort, time O(nlogn), space O(1 )
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        ListNode mid = walker.next;
        walker.next = null;
        ListNode begin = head;
        mid = sortList(mid);
        begin = sortList(begin);
        return merge(mid, begin);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head1;
        ListNode pre = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) head1 = head1.next;
            else {
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if(head2 != null) pre.next = head2;
        return dummy.next;
    }
}