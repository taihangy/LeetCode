public class PartitionList{
	public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode pre=helper;
        while(pre.next!=null){
            if(pre.next.val==x) break;
            pre=pre.next;
        }
        ListNode newNode=null;
        if(pre.next==null) {
            newNode=new ListNode(x);
            pre.next=newNode;
        }
        ListNode preX=new ListNode(0);
        preX.next=pre.next;
        ListNode xNode=pre.next;
        pre=helper;
        ListNode cur=preX;
        while(pre.next!=xNode){
            if(pre.next.val>=x){
                ListNode temp1=cur.next;
                ListNode temp2=pre.next.next;
                cur.next=pre.next;
                pre.next.next=temp1;
                pre.next=temp2;
                cur=cur.next;
            }else{
                pre=pre.next;
            }
        }
        if(newNode!=null) cur.next=null;
        while(xNode!=null){
            if(xNode.val<x){
                pre.next=xNode;
                cur.next=xNode.next;
                xNode=xNode.next;
                pre.next.next=null;
                pre=pre.next;
            }else{
                cur=cur.next;
                xNode=xNode.next;
            }
        }
        pre.next=preX.next;
        return helper.next;
    }

    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode walker=helper;
        ListNode runner=helper;
        while(runner.next!=null){
            if(runner.next.val<x){
                if(walker!=runner){
                    ListNode next=runner.next.next;
                    runner.next.next=walker.next;
                    walker.next=runner.next;
                    runner.next=next;
                }else{
                    runner=runner.next;
                }
                walker=walker.next;
            }else{
                runner=runner.next;
            }
        }
        return helper.next;
    }
}