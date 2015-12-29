/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // time O(number of ListNode * log(number of ListNode))
    // space O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            if(next.next != null) pq.offer(next.next);
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}