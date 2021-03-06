/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    //postorder的每个subtree的最后一位是r该subtree的root
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length!=postorder.length) return null;
        //更方便查找index，可以将root对应的inorder的index找出来避免时间上O(n)的search，取代的是空间O(n)
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    private TreeNode helper(int[] inorder,int inL,int inR,int[] postorder,int posL,int posR,HashMap<Integer,Integer> map){
        if(posL>posR||inL>inR) return null;
        TreeNode root=new TreeNode(postorder[posR]);
        int index=map.get(root.val);
        root.left=helper(inorder,inL,index-1,postorder,posL,posL+index-inL-1,map);
        root.right=helper(inorder,index+1,inR,postorder,posL+index-inL,posR-1,map);
        return root;
    }
}