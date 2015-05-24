/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //保存pre，cur和next,注意要先统计size，这样最后剩余就不用处理处理
    //空间复杂度O(1),时间复杂度O(2n不到)=O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        cur=head;
        while(cur!=null&&size>=k){
            int count=1;
            ListNode next=cur.next;
            while(count<k&&next!=null){
                count++;
                ListNode temp=next.next;
                next.next=cur;
                cur=next;
                next=temp;
            }
            ListNode newpre=pre.next;
            pre.next.next=next;
            pre.next=cur;
            pre=newpre;
            cur=next;
            size-=k;
        }
        return dummy.next;
    }
}