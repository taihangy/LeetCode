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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        HashMap<Integer, ArrayList<Integer>> ctn = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<TreeNode, Integer> ntc = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ntc.put(root, 0);
        int minCol = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = ntc.get(cur);
            if (!ctn.containsKey(col)) {
                ctn.put(col, new ArrayList<Integer>());
            }
            ctn.get(col).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                ntc.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                ntc.put(cur.right, col + 1);
            }
            minCol = Math.min(minCol, col);
        }
        while (ctn.containsKey(minCol)) {
            res.add(ctn.get(minCol++));
        }
        return res;
    }
}