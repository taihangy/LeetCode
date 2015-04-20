public class Reorderlist{
	//自己的版本
	public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode runner=head;
        ListNode walker=head;
        while(runner.next!=null&&runner.next.next!=null){
            runner=runner.next.next;
            walker=walker.next;
        }
        ListNode head2=walker.next;
        walker.next=null;
        ListNode head1=head;
        
        walker=head2;
        runner=head2.next;
        walker.next=null;
        ListNode m=null;
        while(runner!=null){
            m=runner.next;
            runner.next=walker;
            walker=runner;
            runner=m;
        }
        head2=walker;
        ListNode n=null;
        while(head2!=null){
            m=head1.next;
            n=head2.next;
            head1.next=head2;
            head2.next=m;
            head1=m;
            head2=n;
        }
    }

    //网上的版本
    public void reorderList(ListNode head) {
    if(head == null || head.next==null)
    {
        return;
    }
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null)
    {
        walker = walker.next;
        runner = runner.next.next;
    }
    ListNode head1 = head;
    ListNode head2 = walker.next;
    walker.next = null;
    head2 = reverse(head2);
    while(head1!=null && head2!=null)
    {
        ListNode next = head2.next;
        head2.next = head1.next;
        head1.next = head2;
        head1 = head2.next;
        head2 = next;
    }
}
//非递归的reverse
private ListNode reverse(ListNode head)
{
    ListNode pre=null;
    ListNode cur=head;
    while(cur!=null){
    	ListNode next=cur.next;
    	cur.next=pre;
    	pre=cur;
    	cur=next;
    }
    return pre;
}
//递归解法的reverse
private ListNode reverse(ListNode head){
	if(head==null||head.next) return head;
	return recursive_reverse(head,head.next);
}
private ListNode recursive_reverse(ListNode cur,ListNode next){
	if(next==null) return cur;
	ListNode newHead=recursive_reverse(cur.next,next.next);
	next.next=cur;
	cur.next=null;
	return newHead;
}
}