public class LinkedListCycle{
    //使用O(n)多余空间保存node
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

    //两指针大法，一个走两步，一个一步肯定是能遇到的
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