/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode next = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = null, pre = dummy;
        while(next != null) {
            //Find if there is any existed node in map and then connect pre.next to cur
            if(!map.containsKey(next)) {
                cur = new RandomListNode(next.label);
                map.put(next, cur);
            } 
            else {
                cur = map.get(next);
            }
            pre.next = cur;
            //Find if there is any existed random node in map and connecting it with cur.random
            if(next.random != null) {
                if(!map.containsKey(next.random)) {
                    cur.random = new RandomListNode(next.random.label);
                    map.put(next.random, cur.random);
                }
                else {
                    cur.random = map.get(next.random);
                }
            }
            //Move forword
            next = next.next;
            pre = cur;
        }
        return dummy.next;
    }
}