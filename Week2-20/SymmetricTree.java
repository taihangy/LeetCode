/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //solution 1 of recursive
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    //左右子树根据中心对称去比较
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        else if(root1==null||root2==null)
            return false;
        else if(root1.val!=root2.val)
            return false;
        else
            return helper(root1.left,root2.right)&&helper(root1.right,root2.left);
    }

    //solution 2 for iteration
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if(root.left==null||root.right==null) return false;
        //通过Queue的方法，levelOrderTraversal检查是否对称
        LinkedList<TreeNode> l1=new LinkedList<TreeNode>();
        LinkedList<TreeNode> l2=new LinkedList<TreeNode>();
        l1.add(root.left);
        l2.add(root.right);
        while(!l1.isEmpty()&&!l2.isEmpty()){
            TreeNode n1=l1.poll();
            TreeNode n2=l2.poll();
            if(n1.val!=n2.val) return false;
            else if(n1.left==null&&n2.right!=null||n1.left!=null&&n2.right==null) return false;
            else if(n1.right==null&&n2.left!=null||n1.right!=null&&n2.left==null) return false;
            if(n1.left!=null&&n2.right!=null){
                l1.add(n1.left);
                l2.add(n2.right);
            }
            if(n2.left!=null&&n1.right!=null){
                l1.add(n1.right);
                l2.add(n2.left);
            }
        }
        return true;
    }
}