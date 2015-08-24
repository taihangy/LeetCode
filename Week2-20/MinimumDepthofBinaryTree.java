/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthofBinaryTree{
	public int minDepth(TreeNode root){
		//出口，与MaxDepth略有不同，若左（右）子树有一个是0，则找另外一边的最小值
		//因为如果还含有子树，说明该节点还没达到leaf
		if(root==null) return 0;
		if(root.left==null) return minDepth(root.right)+1;
		if(root.right==null) return minDepth(root.left)+1;
		return Math.min(minDepth(root.left),minDepth(root.right))+1;
	}
}