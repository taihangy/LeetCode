public class Solution{
	public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(root,0);
    }
    private int helper(TreeNode root,int sum){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 10*sum+root.val;
        return helper(root.left,10*sum+root.val)+helper(root.right,10*sum+root.val);
    }
}