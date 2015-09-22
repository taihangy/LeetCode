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
    /**
    * Recursive version of Inorder traversal
    */
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

    /** 
    * Non-recursive by using two stacks to track each level
    * Time O(n), Space O(n)
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> stackEven = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stackOdd = new LinkedList<TreeNode>();
        stackEven.push(root);
        int level = 1;
        List<Integer> list = null;
        TreeNode tn = null;
        while(!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            list = new ArrayList<Integer>();
            if(level % 2 == 0) {
                while(!stackOdd.isEmpty()) {
                    tn = stackOdd.pop();
                    list.add(tn.val);
                    if(tn.right != null) stackEven.push(tn.right);
                    if(tn.left != null) stackEven.push(tn.left);
                }
            }
            else {
                while(!stackEven.isEmpty()) {
                    tn = stackEven.pop();
                    list.add(tn.val);
                    if(tn.left != null) stackOdd.push(tn.left);
                    if(tn.right != null) stackOdd.push(tn.right);
                }
            }
            res.add(list);
            level++;
        }
        return res;
    }
}