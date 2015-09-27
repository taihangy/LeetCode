/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // same as 1
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

    // level order traversal recursive version
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        List<TreeLinkNode> last = new ArrayList<TreeLinkNode>();
        last.add(root);
        helper(last);
    }
    
    private void helper(List<TreeLinkNode> last) {
        if(last.isEmpty() || last.size() == 0) return;
        List<TreeLinkNode> cur = new ArrayList<TreeLinkNode>();
        int size = last.size();
        for(int i = 0; i < size; i++) {
            TreeLinkNode node = last.get(i);
            if(i == size - 1) node.next = null;
            else node.next = last.get(i + 1);
            if(node.left != null) cur.add(node.left);
            if(node.right != null) cur.add(node.right);
        }
        helper(cur);
    }
}