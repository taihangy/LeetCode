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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;
        helper(root, res);
        return res[0];
    }
    
    private void helper(TreeNode root, int[] res) {
        int curLen = res[1];
        if(root.left != null) {
            if(root.left.val == root.val + 1) {
                res[1] = curLen + 1;
                if(res[0] < res[1]) {
                    res[0] = res[1];
                }
            } else {
                res[1] = 1;
            }
            helper(root.left, res);
        }
        if(root.right != null) {
            if(root.right.val == root.val + 1) {
                res[1] = curLen + 1;
                if(res[0] < res[1]) {
                    res[0] = res[1];
                }
            } else {
                res[1] = 1;
            }
            helper(root.right, res);
        }
    }
}