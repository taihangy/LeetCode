public class LinkedListCycle2{
    //空间O(1)，时间O(2n)=O(n),设walker走了s步，在循环前a步，循环里b步遇到runner，则a+b=s
    //设runner走了2s步，循环k圈，每圈c个，则a+b+kc=2s 
    //得到a=kc-b，则说明walker从head走a步=runner从相遇点走kc-b步，刚好在起点相遇
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

    //用额外O(n)空间
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