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
        if(root == null || p == null || q == null) return null;
        if(p == q) return p;
        List<TreeNode> pList = new ArrayList<TreeNode>();
        findPath(root, p, pList);
        List<TreeNode> qList = new ArrayList<TreeNode>();
        findPath(root, q, qList);
        int i = 0;
        while(i < pList.size() && i < qList.size()) {
            if(pList.get(i) != qList.get(i)) return pList.get(i - 1);
            i++;
        }
        return i < pList.size()? pList.get(i - 1) : qList.get(i - 1);
    }
    
    private boolean findPath(TreeNode x, TreeNode tn, List<TreeNode> path) {
        if(x == null) return false;
        if(x == tn) {
            path.add(tn);
            return true;
        }
        path.add(x);
        if(findPath(x.left, tn, path)) return true;
        if(findPath(x.right, tn, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}