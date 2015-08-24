/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InsertionSortList {
    //Insertion sort，保有两个变量，空间O(1)，平均在时间O(n^2/4)
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode walker=helper;
        ListNode runner=helper;
        while(runner.next!=null){
            if(runner.next.val<=walker.next.val){
                if(walker!=runner){
                    ListNode next=runner.next.next;
                    runner.next.next=walker.next;
                    walker.next=runner.next;
                    runner.next=next;
                }else{
                    runner=runner.next;
                }
            }
            else{
                walker=walker.next;
                while(walker!=runner&&runner.next.val>walker.next.val){
                    walker=walker.next;
                }
                if(walker!=runner){
                    ListNode next=runner.next.next;
                    runner.next.next=walker.next;
                    walker.next=runner.next;
                    runner.next=next;
                }else{
                    runner=runner.next;
                }
                walker=helper;
            }
        }
        return helper.next;
    }
}