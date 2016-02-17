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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        return findClosest(root, target);
    }
    
    private int findClosest(TreeNode root, double target) {
        if (target >= root.val - 0.5 && target < root.val + 0.5) return root.val;
        else if (target < root.val - 0.5) {
            if (root.left == null) return root.val;
            else if (isLeaf(root.left)) 
                return (double) (root.val + root.left.val) / 2 > target ? root.left.val : root.val;
            else return findClosest(root.left, target);
        }
        else {
            if (root.right == null) return root.val;
            else if (isLeaf(root.right)) 
                return (double) (root.val + root.right.val) / 2 > target ? root.val : root.right.val;
            else return findClosest(root.right, target);
        }
    }
    
    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}