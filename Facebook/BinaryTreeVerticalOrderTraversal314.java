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
        if (root == null) {
            return res;
        }
        HashMap<Integer, ArrayList<Integer>> colToNodes = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<TreeNode, Integer> nodeToCol = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        nodeToCol.put(root, 0);
        int minCol = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = nodeToCol.get(cur);
            if (!colToNodes.containsKey(col)) {
                colToNodes.put(col, new ArrayList<Integer>()); 
            }
            colToNodes.get(col).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                nodeToCol.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nodeToCol.put(cur.right, col + 1);
            }
            minCol = Math.min(minCol, col);
        }
        while (colToNodes.containsKey(minCol)) {
            res.add(colToNodes.get(minCol++));
        }
        return res;
    }
}