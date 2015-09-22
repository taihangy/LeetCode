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
    /**
    * Recursive version of Inorder traversal
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode node) {
        if(node == null) return;
        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);
    }

    /** stack就是让某个东西先进去之后等着
    * let right subtree waitting in the stack for left part finish first
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
} 