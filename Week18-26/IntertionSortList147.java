/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, cur = head, next = null;
        while(cur != null) {
            next = cur.next;
            // it will compare from head to cur.prev
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }

    /**
    * Time O(n^2 / 4 + 3n), Space O(2n)
    * Converting linked list to array
    */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // list size
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        // copy it into array
        int[] nums = new int[count];
        cur = head;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        // insertion sort array 
        insertionSort(nums);

        // construct a new list
        ListNode pre = new ListNode(nums[0]);
        ListNode newH = pre;
        
        for(int i = 1; i < nums.length; i++) {
            cur = new ListNode(nums[i]);
            pre.next = cur;
            pre = cur;
        }
        return newH;
    }

    // improve version of insertsort, it will improve a lot
    private void insertionSort(int[] nums) {
        int N = nums.length;
        for(int i = 1; i < N; i++) {
            int store = nums[i];
            int j;
            for(j = i; j > 0 && nums[j - 1] > store; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = store;
        }
    }
}