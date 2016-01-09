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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        List<TreeNode> pList = new ArrayList<TreeNode>();
        List<TreeNode> qList = new ArrayList<TreeNode>();
        findPath(pList, root, p);
        findPath(qList, root, q);
        int index = 0;
        while (index < pList.size() && index < qList.size()) {
            if(pList.get(index) != qList.get(index)) return pList.get(index - 1);
            index++;
        }
        return index >= pList.size() ? qList.get(index - 1) : pList.get(index - 1);
    }
    
    private boolean findPath(List<TreeNode> path, TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (s == t) {
            path.add(t);
            return true;
        }
        path.add(s);
        if(findPath(path, s.left, t)) return true;
        if(findPath(path, s.right, t)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}