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
        if(target < root.val + 0.5 && target >= root.val - 0.5) return root.val;
        else if(target < root.val - 0.5) {
            if(root.left == null) return root.val;
            else if(isLeaf(root.left)) {
                return (double)(root.val + root.left.val) / 2 > target ? root.left.val : root.val;
            }
            else return closestValue(root.left, target);
        }
        else {
            if(root.right == null) return root.val;
            else if(isLeaf(root.right)) {
                return (double)(root.val + root.right.val) / 2 < target ? root.right.val : root.val;
            }
            else return closestValue(root.right, target);
        }
    }
    
    private boolean isLeaf(TreeNode tn) {
        return tn.left == null && tn.right == null;
    }
}