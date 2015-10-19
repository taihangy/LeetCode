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
    /** Recursive version, store the string in res and then using preorder traversal
    * 
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        helper(res, "", root);
        return res;
    }
    private void helper(List<String> res, String item, TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(item + root.val);
            return;
        }
        if(root.left != null) helper(res, item + root.val + "->", root.left);
        if(root.right != null) helper(res, item + root.val + "->", root.right);
    }


    /** DFS + Stack
    * Need two stacks two store both node and string value for each node respectively
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        stack.push(root);
        strStack.push("");
        while(!stack.isEmpty()) {
            String str = strStack.pop();
            TreeNode node = stack.pop();
            if(node.right == null && node.left == null) {
                str += node.val;
                res.add(str);
            }
            if(node.right != null) {
                stack.push(node.right);
                strStack.push(str + node.val + "->");
            }
            if(node.left != null) {
                stack.push(node.left);
                strStack.push(str + node.val + "->");
            }
        }
        return res;
    }

    /** BFS + QUEUE
    * Need two queues two store both node and string value for each node respectively
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<String> strQueue = new LinkedList<>();
        queue.offer(root);
        strQueue.offer("");
        while(!queue.isEmpty()) {
            String str = strQueue.poll();
            TreeNode node = queue.poll();
            str += node.val;
            if(node.left != null || node.right != null) {
                str += "->";
                if(node.left != null) {
                    strQueue.offer(str);
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    strQueue.offer(str);
                    queue.offer(node.right);
                }
            }
            if(node.left == null && node.right == null) {
                res.add(str);
            }
        }
        return res;
    }
}

