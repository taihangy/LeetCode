/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        LinkedList<ListNode> stack=new LinkedList<ListNode>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        ListNode newHead=stack.pop();
        ListNode next=newHead;
        while(!stack.isEmpty()){
            next.next=stack.pop();
            next=next.next;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode last=null;
        ListNode cur=head;
        ListNode next=head.next;
        while(next!=null&&next.next!=null){
            ListNode temp=next.next;
            next.next=cur;
            cur.next=last;
            last=next;
            cur=temp;
            next=temp.next;
        }
        if(next==null){
            cur.next=last;
            return cur;
        }
        next.next=cur;
        cur.next=last;
        return next;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        return helper(head,null);
    }
    private ListNode helper(ListNode cur,ListNode pre){
        if(cur==null) return pre;
        ListNode temp=cur.next;
        cur.next=pre;
        return helper(temp,cur); 
    }
}