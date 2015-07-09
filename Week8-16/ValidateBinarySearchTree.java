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
}