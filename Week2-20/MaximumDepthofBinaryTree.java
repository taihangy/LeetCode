/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthofBinaryTree{
	public int maxDepth(TreeNode root){
		if(root==null) return 0;
		//左右子树的最大值，即树的最大深度
		return Math.max(maxDepth(x.left),maxDepth(x.right))+1;
	}
}