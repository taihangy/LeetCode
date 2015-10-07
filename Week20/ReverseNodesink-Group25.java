/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        //Calculate size of the list
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        //Initialize
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, walker = head, runner = head.next;
        for(int i = 0; i < size / k; i++) {
            //Reverse in range l
            int step = 1;
            while(step++ < k) {
                ListNode next = runner.next;
                runner.next = walker;
                walker = runner;
                runner = next;
            }
            //link the node in correct order
            ListNode preN = pre.next;
            pre.next = walker;
            preN.next = runner;
            walker = runner;
            //Check runner is null
            runner = runner == null? null : runner.next;
            pre = preN;
        }
        return dummy.next;
    }
}