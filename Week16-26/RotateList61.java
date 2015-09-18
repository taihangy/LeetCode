/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // two pass, time O(n), space O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode walker = head;
        // count list nodes
        int len = 0;
        while(walker != null) {
            len++;
            walker = walker.next;
        }
        // mod 
        k = k % len;
        if(k == 0) return head;

        walker = head;
        int count = len - k;
        while(count > 1) {
            walker = walker.next;
            count--;
        }
        ListNode newHead = walker.next;
        walker.next = null;
        walker = newHead;
        while(walker.next != null) {
            walker = walker.next;
        }
        walker.next = head;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode walker = head;
        int len = 1;
        while(walker.next != null) {
            len++;
            walker = walker.next;
        }
        // make it a circle
        walker.next = head;
        k = k % len;
        walker = head;
        int step = len - k - 1;
        while(step > 0) {
            walker = walker.next;
            step--;
        }
        ListNode newHead = walker.next;
        walker.next = null;
        return newHead;
    }
} 