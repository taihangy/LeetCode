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
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> res=new ArrayList<TreeNode>();
        helper(root,res);
        TreeNode cur=root;
        for(int i=1;i<res.size();i++){
            cur.right=res.get(i);
            cur=cur.right;
        }
    }
    private void helper(TreeNode root,ArrayList<TreeNode> res){
        if(root==null) return;
        res.add(root);
        helper(root.left,res);
        helper(root.right,res);
    }
}