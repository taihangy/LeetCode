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
		//保有两个指针，一个runner，一个walker
		ListNode runner=head;
		//n用来跟踪size（小于等于n）
		int i=0;
		while(runner!=null&&i<n){
			runner=runner.next;
			i++;
		}
		//当list的size小鱼n时，直接返回head
		if(i<n) return head;
		//当size==n，则返回head.next（删去head处的值）
		if(runner==null) {
			ListNode oldHead=head;
			head=head.next;
			oldHead.next=null;
			return head;
		}
		//walker跟随走了size-n步，剩下刚好为n步
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