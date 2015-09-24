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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        helper(res, list, root, sum - root.val);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
        if(node == null) return;
        if(sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(node.left != null) {
            list.add(node.left.val);   
            helper(res, list, node.left, sum - node.left.val);
        }
        if(node.right != null) {
            list.add(node.right.val);
            helper(res, list, node.right, sum - node.right.val);
        }
        list.remove(list.size() - 1);
    }
}