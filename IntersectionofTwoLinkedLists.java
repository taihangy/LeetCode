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
public class IntersectionofTwoLinkedLists{
	public ListNode getIntersectionNode(ListNode headA,ListNode headB){
		if(headA==null||headB==null) return null;
		ListNode a=headA;
		ListNode b=headB;
		while(a!=null&&b!=null){
			if(a.val==b.val) return a;
			else if(a.val<b.val) a=a.next;
			else b=b.next;
		}
		return null;
	}
}