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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        helper(res,0,stack);
        return res;
    }
    
    private void helper(List<List<Integer>> res,int level,LinkedList<TreeNode> stack){
        if(stack.isEmpty()) return;
        LinkedList<TreeNode> newStack=new LinkedList<TreeNode>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            TreeNode tn=stack.pop();
            list.add(tn.val);
            if(level%2==0){
                if(tn.left!=null)
                    newStack.push(tn.left);
                if(tn.right!=null)
                    newStack.push(tn.right);
            }else{
                if(tn.right!=null)
                    newStack.push(tn.right);
                if(tn.left!=null)
                    newStack.push(tn.left);
            }
        }   
        res.add(list);
        helper(res,level+1,newStack);
    }
}