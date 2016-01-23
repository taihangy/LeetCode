/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mid = even;
        while (odd != null && even != null) {
            odd.next = even.next;
            if (odd.next == null) {
                break;
            }
            odd = odd.next;
            if (odd != null) {
                even.next = odd.next;
            }
            even = even.next;
        }
        odd.next = mid;
        return dummy.next;
    }
}