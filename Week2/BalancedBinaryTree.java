/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree{
	public boolean isBalanced(TreeNode root){
		return helper(root)>=0;
	}

	//用recursive算每一个TreeNode的左右子树深度，如果深度相差1以上，或者左(右)子树中含有深度相差1以上的，则一直返回0
	public int helper(TreeNode root){
		if(root==null) return 0;
		int left=helper(root.left);
		int right=helper(root.right);
		if(Math.abd(left-right)>1)
			return -1;
		if(left<0&&right<0)
			return -1;
		//返回节点最大深度
		return Math.max(left,right)+1;
	}
}