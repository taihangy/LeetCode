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
    //
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return -1;
        helper(root);
        return max;
    }
    private int helper(TreeNode x){
        if(x==null) return 0;
        int left=helper(x.left);
        int right=helper(x.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int sum=x.val+left+right;
        max=max<sum?sum:max;
        return Math.max(x.val+left,x.val+right);
    }
}