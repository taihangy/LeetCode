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
    public int countNodes(TreeNode root) {
        TreeNode left = root;
        int leftHeight = 0;
        while(left != null) {
            leftHeight++;
            left = left.left;
        }
        TreeNode right = root;
        int rightHeight = 0;
        while(right != null) {
            rightHeight++;
            right = right.right;
        }
        if(leftHeight == rightHeight) return (1 << leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}