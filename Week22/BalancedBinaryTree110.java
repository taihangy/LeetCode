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
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    
    private int helper(TreeNode x) {
        if(x == null) return 0;
        int left = helper(x.left);
        int right = helper(x.right);
        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;
    }
}