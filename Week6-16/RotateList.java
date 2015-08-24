public class RotateList{
  //思路很清晰，先找到end,以及count，然后算要移多少step，然后找到要编程头结点的node，指针操作
  //时间O(2n)，空间O(1)
	public ListNode rotateRight(ListNode head, int k) {
       if(head==null||head.next==null) return head;
       ListNode helper=new ListNode(0);
       helper.next=head;
       ListNode pre=helper;
       int count=0;
       while(pre.next!=null){
           count++;
           pre=pre.next;
       }
       ListNode end=pre;
       pre=helper.next;
       int step=k%count;
       int i=0;
       while(i<count-step-1){
           pre=pre.next;
           i++;
       }
       end.next=helper.next;
       helper.next=pre.next;
       pre.next=null;
       return helper.next;
    }
}