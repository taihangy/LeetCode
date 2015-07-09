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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        helper(root,0,sum,new ArrayList<Integer>(),res);
        return res;
    }
    private void helper(TreeNode root,int path,int sum,ArrayList<Integer> list,List<List<Integer>> res){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            path+=root.val;
            if(path==sum){
                list.add(root.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        helper(root.left,path+root.val,sum,list,res);
        helper(root.right,path+root.val,sum,list,res);
        list.remove(list.size()-1);
    }
}