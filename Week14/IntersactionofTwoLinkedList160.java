/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        int countA = 1;
        ListNode b = headB;
        int countB = 1;
        // check lists' node number individually 
        while(a.next != null) {
            a = a.next;
            countA++;
        } 
        while(b.next != null) {
            b = b.next;
            countB++;
        }
        // if the last node is not the same, then no intersection
        if(a != b) return null;
        // let two lists step into the length
        if(countA < countB) {
            b = step(countB - countA, headB);
            a = headA;
        } else if(countA > countB){
            a = step(countA - countB, headA);
            b = headB;
        } else {
            a = headA;
            b = headB;
        }
        // easily find the first intersected node
        while(a != null) {
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
    
    private ListNode step(int n, ListNode head) {
        ListNode cur = head;
        for(int i = 0; i < n && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // version 2, very clever
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        // 
        while(l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
            if(l1 == l2) return l1;
            // if l1 reach null, moving it to headB, vice versa
            // this will lead to two pointers step at the same pace, which leads to the intersection
            if(l1 == null) l1 = headB;
            if(l2 == null) l2 = headA;
        }
        return l1;
    }
}