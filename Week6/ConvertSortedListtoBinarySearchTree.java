/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ArrayList<ListNode> list=new ArrayList<ListNode>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        int lo=0,hi=list.size()-1;
        TreeNode root=new TreeNode(list.get((lo+hi)/2).val);
        return helper(root,list,lo,hi);
    }
    private TreeNode helper(TreeNode root,ArrayList<ListNode> list, int lo,int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;
        TreeNode left=new TreeNode(list.get((lo+mid-1)/2).val);
        root.left=helper(left,list,lo,mid-1);
        TreeNode right=new TreeNode(list.get((mid+1+hi)/2).val);
        root.right=helper(right,list,mid+1,hi);
        return root;
    }
}