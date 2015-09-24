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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        int total = 0;
        for(String s : res) {
            int elem = Integer.parseInt(s);
            total += elem;
        }
        return total;
    }
    private void helper(List<String> res, TreeNode node, StringBuilder sb) {
        if(node.left == null && node.right == null) {
            sb.append(node.val);
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(node.val);
        if(node.left != null)
            helper(res, node.left, sb);
        if(node.right != null)
            helper(res, node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helpe r(TreeNode root, int sum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 10 * sum + root.val;
        return helper(root.left, 10 * sum + root.val) + helper(root.right, 10 * sum + root.val);
    }

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int total = 0;
        LinkedList<Integer> qVal = new LinkedList<>();
        LinkedList<TreeNode> qNode = new LinkedList<>();
        qVal.offer(root.val);
        qNode.offer(root);
        while(!qNode.isEmpty()) {
            int partSum = qVal.poll();
            TreeNode cur = qNode.poll();
            if(cur.left == null && cur.right == null) {
                total += partSum;
            }
            else {
                if(cur.left != null) {
                    qNode.offer(cur.left);
                    qVal.offer(partSum * 10 + cur.left.val);
                } 
                if(cur.right != null) {
                    qNode.offer(cur.right);
                    qVal.offer(partSum * 10 + cur.right.val);
                }
            }
        }
        return total;
    }
}