/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //recursive from end to begin O(n)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return reverseList(head, null);
    }
    
    private ListNode reverseList(ListNode cur, ListNode pre) {
        if(cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList(next, cur);
    }

    // from begin to end O(n), space O(1)
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //stack version time O(n) space O(n)
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
}