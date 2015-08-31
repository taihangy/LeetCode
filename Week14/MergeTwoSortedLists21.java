/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // just be aware the length differences issue
        // time O(n + m), space O(1), which n and m is length of l1 and l2 respectively
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null) {
            while(l2 != null) {
                cur.next = l2;
                cur = cur.next;
                l2= l2.next;
            }
        } 
        if(l2 == null) {
            while(l1 != null) {
                cur.next = l1;
                cur = cur.next;
                l1= l1.next;
            }
        }
        return dummy.next;
    }

    // more compact than the upper one
    // remain one walking pointer cur
    // if cur.next.val <= another list's val
    // then cur.next to another list, another list to this list
    // otherwise, keep cur going forward down this list
    // time O(n + m), space O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l2 != null) {
            while(cur.next != null && cur.next.val <= l2.val)
                cur = cur.next;
            l1 = cur.next;
            cur.next = l2;
            l2 = l1;
        }
        return dummy.next;
    }
}