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
public class RemoveNthNodeFromEndofList{
	public ListNode removeNthFromEnd(ListNode head,int n){
		if(head==null) return null;
		ListNode runner=head;
		int i=0;
		while(runner!=null&i<n){
			runner=runner.next;
			i++;
		}
		if(i<n) return head;
		if(runner==null) {
			ListNode oldHead=head;
			head=head.next;
			oldHead.next=null;
			return head;
		}
		ListNode walker=head;
		while(runner.next!=null){
			walker=walker.next;
			runner=runner.next;
		}
		ListNode oldWalkerNext=walker.next;
		walker.next=walker.next.next;
		oldWalkerNext.next=null;
		return head;
	}
}