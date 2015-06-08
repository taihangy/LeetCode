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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int[] count=new int[1];
        helper(root,count);
        return count[0];
    }
    private void helper(TreeNode x,int[] count){
        if(x==null) return;
        count[0]++;
        helper(x.left,count);
        helper(x.right,count);
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode temp=root;
        int rightHeight=0;
        while(temp!=null){
            rightHeight++;
            temp=temp.right;
        }
        temp=root;
        int leftHeight=0;
        while(temp!=null){
            leftHeight++;
            temp=temp.left;
        }
        if(leftHeight==rightHeight)
            return (1<<leftHeight)-1;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}