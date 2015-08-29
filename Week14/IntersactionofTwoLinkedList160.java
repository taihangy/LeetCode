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
        while(a.next != null) {
            a = a.next;
            countA++;
        } 
        while(b.next != null) {
            b = b.next;
            countB++;
        }
        if(a != b) return null;
        if(countA < countB) {
            b = step(countB - countA, headB);
            a = headA;
        } else if(countA > countB){
            a = step(countA - countB, headA);
            b = headB;
        } else {
            a =headA;
            b = headB;
        }
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
}