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
public class RemoveDuplicatesfromSortedListII{
	public  ListNode deleteDuplicates(ListNode head){
		if(head==null) return null;
		ListNode sentinel=new ListNode(0);
		sentinel.next=head;
		ListNode pre=sentinel;
		ListNode cur=head;

		while(cur!=null){
			while(cur.next!=null&&pre.next.val==cur.next.val){
				cur=cur.next;
			}
			if(pre.next==cur){
				pre=cur;
			} else{
				pre.next=cur.next;
			}
			cur=cur.next;
		}
		return sentinel.next;
	}
}