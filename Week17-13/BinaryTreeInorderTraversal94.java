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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode node) {
        if(node == null) return;
        helper(res, node.left);
        res.add(node.val);
        helper(res, node.right);
    }


    /**
    * Iterative version using stack
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            res.add(tn.val);
            TreeNode right = tn.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return res;
    }
}