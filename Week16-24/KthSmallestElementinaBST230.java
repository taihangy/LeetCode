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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if(k <= count) {
            return kthSmallest(root.left, k);
        } else if(k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }
    private int countNode(TreeNode n) {
        if(n == null) return 0;
        return 1 + countNode(n.left) + countNode(n.right);
    }

    private int number = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return number;
    }
    private void inorder(TreeNode n) {
        if(n.left != null) inorder(n.left);
        count--;
        if(count == 0) {
            number = n.val;
            return;
        }
        if(n.right != null) inorder(n.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(k != 0) {
            TreeNode tn = stack.pop();
            k--;
            if(k == 0) return tn.val;
            TreeNode right =tn.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}