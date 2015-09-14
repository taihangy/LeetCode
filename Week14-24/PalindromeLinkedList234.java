/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // time O(n), space O(n)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        HashMap<Integer, ListNode> nodePos = new HashMap<Integer, ListNode>();
        ListNode cur = head;
        int pos = 0;
        while(cur != null) {
            nodePos.put(pos, cur);
            pos++;
            cur = cur.next;
        }
        for(int i = 0, j = pos - 1; i < pos / 2; i++, j--) {
            ListNode begin = nodePos.get(i);
            ListNode last = nodePos.get(j);
            if(begin.val != last.val) return false;
        }
        return true;
    }
}