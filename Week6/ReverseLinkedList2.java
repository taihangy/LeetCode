public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode runner=helper;
        int count=0;
        while((++count)<=m-1){
            runner=runner.next;
        }
        ListNode pre=runner;
        ListNode walker=pre.next;
        runner=walker.next;
        while(runner!=null&&count<n){
            ListNode temp=runner.next;
            runner.next=walker;
            walker=runner;
            runner=temp;
            count++;
        }
        if(pre.next.next!=null)
            pre.next.next=runner;
        pre.next=walker;
        return helper.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode pre=helper;
        int count=0;
        while((++count)<=m-1){
       		pre=pre.next;
        }

        ListNode mNode=pre.next;
        ListNode cur=mNode.next;
        while(cur!=null&&count<n){
        	ListNode next=cur.next;
        	cur.next=pre.next;
        	pre.next=cur;
        	mNode.next=next;
        	cur=next;
        	count++;
        }
        return helper.next;
    }
}