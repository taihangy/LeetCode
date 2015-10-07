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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode node, Long min, Long max) {
        if(node == null) return true;
        if((long)node.val <= min || (long)node.val >= max) return false;
        return isValid(node.left, min, (long)node.val) && isValid(node.right, (long)node.val, max);
    }


    // inorder traversal
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    
    private boolean helper(TreeNode tn, ArrayList<Integer> pre) {
        if(tn == null) return true;
        boolean left = helper(tn.left, pre);
        if(pre.get(0) != null && tn.val <= pre.get(0)) return false;
        pre.set(0, tn.val);
        boolean right = helper(tn.right, pre);
        return left && right;
    }

    // recursion
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        return (root.val >= min && root.val <= max) &&
               (root.left == null || helper(root.left, min, (long)root.val - 1)) &&
               (root.right == null || helper(root.right, (long)root.val + 1, max));
    }
}