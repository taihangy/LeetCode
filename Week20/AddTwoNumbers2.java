/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null || l2 == null) return l1 == null? l2 : l1;
        //Let l1 be the longer one
        ListNode cur1 = l1, cur2 = l2;
        while(cur1 != null && cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(cur1 == null && cur2 != null) {
        	ListNode temp = l1;
        	l1 = l2;
        	l2 = temp;
        } 
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        //If we can do it in place
        int sum = 0, carry = 0;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        //Check if l1 is null
        while(carry != 0 && l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            pre = pre.next;
        }
        if(carry != 0) {
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }
}