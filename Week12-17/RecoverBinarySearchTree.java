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
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> res=new ArrayList<TreeNode>();
        ArrayList<TreeNode> inorder=new ArrayList<TreeNode>();
        inorder.add(null);
        helper(root,res,inorder);
        if(res.size()>0){
            int temp=res.get(0).val;
            res.get(0).val=res.get(1).val;
            res.get(1).val=temp;
        }
    }
    private void helper(TreeNode x,ArrayList<TreeNode> res,ArrayList<TreeNode> inorder){
        if(x==null) return;
        helper(x.left,res,inorder);
        if(inorder.get(0)!=null&&inorder.get(0).val>x.val){
            if(res.size()==0){
                res.add(inorder.get(0));
                res.add(x);
            }else{
                res.set(1,x);
            }
        }
        inorder.set(0,x);
        helper(x.right,res,inorder);
    }
}