
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //中序遍历，注意第一个值为null
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        ArrayList<Integer> pre=new ArrayList<Integer>();
        pre.add(null);
        return helper(root,pre);
    }
    private boolean helper(TreeNode root,ArrayList<Integer> pre){
        if(root==null) return true;
        boolean left=helper(root.left,pre);
        if(pre.get(0)!=null&&root.val<=pre.get(0)) return false;
        pre.set(0,root.val);
        boolean right=helper(root.right,pre);
        return right&&left;
    }

    //分治的思想，注意要是long的最大值最小值，避免TreeNode是最大值最小值
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,long min,long max){
        if(root==null) return true;
        if((long)root.val<=min||(long)root.val>=max) return false;
        return helper(root.left,min,(long)root.val)&&helper(root.right,(long)root.val,max);
    }

    //分治2，保存每个node的最大最小值
    private class Node{
        long min;
        long max;
        Node(long min,long max){
            this.min=min;
            this.max=max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return true;
        Node isBst=helper(root);
        return isBst.max!=Long.MAX_VALUE&&isBst.min!=Long.MIN_VALUE;
    }
    private Node helper(TreeNode x){
        if(x==null){
            return new Node(Long.MAX_VALUE,Long.MIN_VALUE);
        }
        Node left=helper(x.left);
        Node right=helper(x.right);
        
        long max=Math.max(x.val,right.max);
        long min=Math.min(x.val,left.min);
        if((long)x.val>left.max&&(long)x.val<right.min)
            return new Node(min,max);
        else
            return new Node(Long.MIN_VALUE,Long.MAX_VALUE);
    }
}