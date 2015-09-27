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
    // RECURSION
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null || right == null || left.val != right.val) return false;
        else {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
    }

    // level order traversal
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root.left);
        q2.offer(root.right);
        while(!q1.isEmpty() && !q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1.left != null && node2.right == null ||
               node1.right != null && node2.left == null ||
               node1.left == null && node2.right != null ||
               node1.right == null && node2.left != null ||
               node1.val != node2.val) {
                   return false;
               }
            if(node1.left != null && node2.right != null) {
                q1.offer(node1.left);
                q2.offer(node2.right);
            }
            if(node1.right != null && node2.left != null) {
                q1.offer(node1.right);
                q2.offer(node2.left);
            }
        }
        return true;
    }
}