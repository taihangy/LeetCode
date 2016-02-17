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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> small = new Stack<>(), big = new Stack<>();
        initStack(root, target, small, true);
        initStack(root, target, big, false);
        while (k-- > 0) {
            if (small.isEmpty()) res.add(big.pop());
            else if (big.isEmpty()) res.add(small.pop());
            else if (target - small.peek() < big.peek() - target) res.add(small.pop());
            else res.add(big.pop());
        }
        return res;
    }
    
    private void initStack(TreeNode root, double target, Stack<Integer> stack, boolean flag) {
        if (root == null) return;
        initStack(flag? root.left : root.right, target, stack, flag);
        if ((flag && root.val > target) || (!flag && root.val <= target)) return;
        stack.push(root.val);
        initStack(flag? root.right : root.left, target, stack, flag);
    }
}