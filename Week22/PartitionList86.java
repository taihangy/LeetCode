/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode small = dummy;
        ListNode walker = dummy;
        while(walker != null && walker.next != null) {
            if(walker.next.val < x) {
                if(small != walker) {
                    ListNode next = walker.next.next;
                    walker.next.next = small.next;
                    small.next = walker.next;
                    walker.next = next;
                }
                small = small.next;
                if(small == walker.next) walker = walker.next;
                continue;
            }
            walker = walker.next;
        }
        return dummy.next;
    }
}