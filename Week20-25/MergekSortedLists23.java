/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.offer(lists[i]);
        }
        if(pq.isEmpty()) return null;
        ListNode head = pq.poll();
        if(head.next != null) pq.offer(head.next);
        ListNode cur = head;
        while(!pq.isEmpty()) {
            ListNode next = pq.poll();
            if(next.next != null) pq.offer(next.next);
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}