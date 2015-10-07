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
    // postorder: root at the end, inorder: the right part of root is the left tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        assert inorder != null && postorder != null && inorder.length == postorder.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode helper(int[] inorder, int inL, int inR,
                            int[] postorder, int postL, int postR, HashMap<Integer, Integer> map)
    {
        if(inL > inR || postL > postR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);
        root.left = helper(inorder, inL, index - 1, postorder, postL, postL + index - inL - 1, map);
        root.right = helper(inorder, index + 1, inR, postorder, postL + index - inL, postR - 1, map);
        return root;
    }
}