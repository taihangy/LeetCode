public class AddTwoNumbers{
    //就是加法的正常思路
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode helper1=new ListNode(0);
        helper1.next=l1;
        ListNode helper2=new ListNode(0);
        helper2.next=l2;
        int carry=0;
        int digit=0;
        ListNode end1=null;
        ListNode end2=null;
        while(l1!=null&&l2!=null){
            digit=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            l1.val=digit;
            l2.val=digit;
            end1=l1;
            end2=l2;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null&&l2==null){
            if(carry==0) return helper1.next;
            else{
                ListNode end=new ListNode(carry);
                end1.next=end;
                return helper1.next;
            }
        }
        else if(l1==null&&l2!=null){
            if(carry==0) return helper2.next;
            else {
                while(carry!=0&&l2!=null){
                    digit=(l2.val+carry)%10;
                    carry=(l2.val+carry)/10;
                    l2.val=digit;
                    end2=l2;
                    l2=l2.next;
                }
                if(carry==1){
                    ListNode end=new ListNode(carry);
                    end2.next=end;
                }
                return helper2.next;
            }
        }
        else{
            if(carry==0) return helper1.next;
            else {
                while(carry!=0&&l1!=null){
                    digit=(l1.val+carry)%10;
                    carry=(l1.val+carry)/10;
                    l1.val=digit;
                    end1=l1;
                    l1=l1.next;
                }
                if(carry==1){
                    ListNode end=new ListNode(carry);
                    end1.next=end;
                }
                return helper1.next;
            }
        }
    }
}