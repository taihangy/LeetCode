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
        if(root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeLinkNode tn = queue.poll();
            if(!queue.isEmpty()) {
                tn.next = queue.peek();
            }
            if(tn.left != null) {
                next.offer(tn.left);
            }
            if(tn.right != null) {
                next.offer(tn.right);
            }
            if(queue.isEmpty()) {
                queue = next;
                next = new LinkedList<TreeLinkNode>();
            }
        }
    }
     
    public void connect(TreeLinkNode root) {
        helper(root, null);
    }
    private void helper(TreeLinkNode root, TreeLinkNode next) {
        if(root == null) return;
        if(next != null) root.next = next;
        helper(root.left, root.right);
        helper(root.right, root.next == null? null : root.next.left);
    }
}