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
    // recursive, dive and conquer
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);
            for(int j = 0; j < leftTree.size(); j++) {
                for(int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}