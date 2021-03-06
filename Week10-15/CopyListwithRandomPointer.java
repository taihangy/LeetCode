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
        //空间复杂度O(n)，时间复杂度O(n)，基本没难度，当然可以不用额外空间，下次可以在做
        if(head==null) return null;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode helper=new RandomListNode(0);
        RandomListNode pre=helper,cur;
        while(head!=null){
            if(map.containsKey(head)){
                cur=map.get(head);
            }else{
                cur=new RandomListNode(head.label);
                map.put(head,cur);
            }
            pre.next=cur;
            if(head.random!=null){
                if(map.containsKey(head.random)){
                    cur.random=map.get(head.random);
                }else{
                    cur.random=new RandomListNode(head.random.label);
                    map.put(head.random,cur.random);
                }
            }
            pre=cur;
            head=head.next;
        }
        return helper.next;
    }
}