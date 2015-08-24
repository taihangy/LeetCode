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
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        //和linked-list其他题目差不多，加一个helper
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode pre=helper;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            ListNode next=cur.next.next;
            //第二个指向第一个
            cur.next.next=cur;
            //前一个指向第二个
            pre.next=cur.next;
            //第一个如果存在第四个就指向第四个，否则第三个
            if(next!=null&&next.next!=null) cur.next=next.next;
            else cur.next=next;
            pre=cur;
            cur=next;
        }
        return helper.next;
    }
}