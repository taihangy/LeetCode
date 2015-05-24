/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //时间复杂度为O(n),空间复杂度为O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        ListComparator comparator=new ListComparator();
        
        //将list放入PQ中，每次可以取出最小的，并将下一个放入PQ中
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.length,comparator);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                pq.add(head.next);
            }
        }
        return dummy.next;
    }
    private class ListComparator implements Comparator<ListNode>{
        public int compare(ListNode left,ListNode right){
            if(left==null){
                return -1;
            }
            if(right==null){
                return 1;
            }
            return left.val-right.val;
        }
    }
}