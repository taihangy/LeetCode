/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode root;
    private LinkedList<TreeNode> res;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.res = new LinkedList<TreeNode>();
        helper(res, root);
    }
    
    private void helper(LinkedList<TreeNode> res, TreeNode x) {
        if(x == null) return;
        helper(res, x.left);
        res.offer(x);
        helper(res, x.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !res.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return res.poll().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */