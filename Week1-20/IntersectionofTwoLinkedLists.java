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
		//保有两个头指针，遍历list，如果相同则返回，不相同，较小的listNode++
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