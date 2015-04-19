/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortList {
    //mergesort的思路就是把队列劈成两半，然后合起来，一共有logn层，每层总共需要n次比较，总时间复杂度O(nlogn)
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        //持有两个指针，runner用来找尾部，每次走两格，walker走一步，找到中间点
        ListNode walker=head;
        ListNode runner=head;
        while(runner.next!=null&&runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
        }
        ListNode head2=walker.next;
        walker.next=null;
        ListNode head1=head;
        //递归分开
        head1=mergeSort(head1);
        head2=mergeSort(head2);
        //合并
        return merge(head1,head2);
    }
    //一般在链表里都会有一个helper，用于处理头结点的问题
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode helper=new ListNode(0);
        helper.next=head1;
        //这里用一个pre就是留下helper的指针以便返回helper.next，也就是head
        ListNode pre=helper;
        while(head1!=null&&head2!=null){
            //这里要用<=因为mergesort可以stable的
            if(head1.val<=head2.val){
                head1=head1.next;
            }
            else{
                //把后半段的头插进去，前半段头不动，后半段头向后一格
                ListNode next=head2.next;
                head2.next=pre.next;
                pre.next=head2;
                head2=next;
            }
            //表明一个循环确定一个
            pre=pre.next;
        }
        //如果后半段还有剩余，pre.next=head2;
        if(head2!=null){
            pre.next=head2;
        }
        //返回头指针
        return helper.next;
    }
}