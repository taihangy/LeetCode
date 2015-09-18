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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode node) {
        if(node == null) return;
        helper(res, node.left);
        helper(res, node.right);
        res.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            stackVal.push(tn.val);
            if(tn.left != null) stack.push(tn.left);
            if(tn.right != null) stack.push(tn.right);
        }
        while(!stackVal.isEmpty()) res.add(stackVal.pop());
        return res;
    }
}