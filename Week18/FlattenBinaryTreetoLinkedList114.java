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
    // pre order
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode right = root.right;
        TreeNode left = root.left;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = right;
    }

    // post order
    private TreeNode next;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    // not accepted but
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, res);
        TreeNode cur = root;
        for(int i = 1; i < res.size(); i++) {
            cur.right = res.get(i);
            cur = cur.right;
        }
    }
    
    private void helper(TreeNode root, ArrayList<TreeNode> res) {
        if(root == null) return;
        res.add(root);
        helper(root.left, res);
        helper(root.right, res);
    }
}