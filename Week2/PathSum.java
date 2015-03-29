public class PathSum{
	public boolean hasPathSum(TreeNode root,int sum){
		//若root==null了还在recursive，则肯定是false了
		if(root==null) return false;
		//若左右子树都为空，数值还不为sum，那也为false，反之为true
        if(root.left==null&&root.right==null&&root.val!=sum) return false;
        if(root.left==null&&root.right==null&&root.val==sum) return true;
        //只要存在就行，因此用||
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	}
}