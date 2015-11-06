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

    // Time O(n), space O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        // find the half of the list
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode half = walker.next;
        ListNode secondHead = reverse(half, null);
        ListNode firstHead = head;
        while(secondHead != null) {
            if(secondHead.val != firstHead.val) return false;
            secondHead= secondHead.next;
            firstHead = firstHead.next;
        }
        return true;
    }
    private ListNode reverse(ListNode cur, ListNode pre) {
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //Using Stack, Time O(n), space O(n)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            stack.push(walker);
            walker = walker.next;
            runner = runner.next.next;
        }
        if(runner.next != null)
            stack.push(walker);
        ListNode mid = walker.next;
        while(!stack.isEmpty() && mid != null) {
            if(mid.val != stack.pop().val) return false;
            mid = mid.next;
        }
        return true;
    }
}