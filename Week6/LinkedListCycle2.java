public class LinkedListCycle2{
	public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode walker=head;
        ListNode runner=head;
        while(runner.next!=null&&runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
            if(walker==runner) break;
        }
        if(runner.next==null||runner.next.next==null) 
            return null;
        runner=head;
        while(walker!=runner){
            walker=walker.next;
            runner=runner.next;
        }
        return runner;
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode cur=head;
        HashSet<ListNode> set=new HashSet<ListNode>();
        while(cur!=null){
            if(!set.add(cur)) return cur;
            cur=cur.next;
        }
        return null;
    }
}