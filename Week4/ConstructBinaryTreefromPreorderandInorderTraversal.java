public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length) return null;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] preorder,int preL,int preR,int[] inorder,int inL,int inR,HashMap<Integer,Integer> map){
        if(preL>preR||inL>inR) return null;
        TreeNode root=new TreeNode(preorder[preL]);
        int index=map.get(root.val);
        root.left=helper(preorder,preL+1,preL+index-inL,inorder,inL,index-1,map);
        root.right=helper(preorder,preL+index-inL+1,preR,inorder,index+1,inR,map);
        return root;
    }
}