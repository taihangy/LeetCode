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
        List<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        postorderTraversal(root,res);
        return res;
    }
    private void postorderTraversal(TreeNode root,List<Integer> res){
        if(root==null) return;
        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        LinkedList<Integer> stackVal=new LinkedList<Integer>();
        LinkedList<TreeNode> stackNode=new LinkedList<TreeNode>();
        TreeNode cur=root;
        stackNode.push(cur);
        while(!stackNode.isEmpty()){
            TreeNode tn=stackNode.pop();
            stackVal.push(tn.val);
            if(tn.left!=null){
                stackNode.push(tn.left);
            }
            if(tn.right!=null){
                stackNode.push(tn.right);
            }
        }
        while(!stackVal.isEmpty())
            res.add(stackVal.pop());
        return res;
    }
}