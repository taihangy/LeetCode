public class BinaryTreeInorderTraversal{
    //没什么好说的，就是递归
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        helper(list,root);
        return list;
    }
    public void helper(List<Integer> list,TreeNode root) {
        if(root==null) return;
        helper(list,root.left);
        list.add(root.val);
        helper(list,root.right);
    }
}