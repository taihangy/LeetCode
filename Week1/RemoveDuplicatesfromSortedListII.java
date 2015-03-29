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
		//第一个能删除时需要保有head之前的sentinel
		ListNode pre=sentinel;
		ListNode cur=head;

		while(cur!=null){
			//寻找遍历指针的next不与pre.next相同的cur
			while(cur.next!=null&&pre.next.val==cur.next.val){
				cur=cur.next;
			}
			//如果pre与cur紧挨，说明没有重复
			if(pre.next==cur){
				pre=cur;
			}
			//反之，重复 
			else{
				pre.next=cur.next;
			}
			cur=cur.next;
		}
		//注意不是head，而是sentinel.next
		return sentinel.next;
	}
}