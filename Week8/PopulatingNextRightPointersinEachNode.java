/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        helper(root,null);
    }
    private void helper(TreeLinkNode root,TreeLinkNode next){
        if(root==null) return;
        if(next==null) root.next=null;
        else root.next=next;
        helper(root.left,root.right);
        helper(root.right,root.next==null?null:root.next.left);
    }
}