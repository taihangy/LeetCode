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
    // preorder: root at front, inorder: the right part of root is the left tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        assert preorder != null && inorder != null && preorder.length == inorder.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int preL, int preR, 
                            int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
        if(preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(root.val);
        root.left = helper(preorder, preL + 1, preL + index - inL, inorder, inL, index - 1, map);
        root.right = helper(preorder, preL + index - inL + 1, preR, inorder, index + 1, inR, map);
        return root;
    }
}