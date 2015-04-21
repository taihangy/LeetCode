public class LinkedListCycle{
	public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode cur=head;
        HashSet<ListNode> set=new HashSet<ListNode>();
        while(cur!=null){
            if(!set.add(cur)) return true;
            cur=cur.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head){
    	if(head==null||head.next==null) return false;
    	ListNode walker=head;
    	ListNode runner=head;
    	while(runner.next!=null&&runner.next.next!=null){
    		walker=walker.next;
    		runner=runner.next.next;
    		if(walker=runner) return true;
    	}
    	return false;
    }
}