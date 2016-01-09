/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String spliter = ",";
    private String N = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        buildString(root, res);
        return res.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder res) {
        if (root == null) {
           res.append(N).append(spliter); 
        }
        else {
            res.append(root.val).append(spliter);
            buildString(root.left, res);
            buildString(root.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(deque);
    }
    
    private TreeNode buildTree(Deque<String> deque) {
        String val = deque.removeFirst();
        if (val.equals(N)) {
            return null;
        } else {
            int value = Integer.valueOf(val);
            TreeNode root = new TreeNode(value);
            root.left = buildTree(deque);
            root.right = buildTree(deque);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));