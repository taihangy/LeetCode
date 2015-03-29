/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal{
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int lastNum=1;
        int curNum=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode tn=queue.poll();
            lastNum--;
            list.add(tn.val);
            if(tn.left!=null){
              queue.add(tn.left);
              curNum++;
            } 
            if(tn.right!=null) {
                queue.add(tn.right);
                curNum++;
            }
            if(lastNum==0){
                lastNum=curNum;
                curNum=0;
                res.add(list);
                list=new ArrayList<Integer>();
            }
        }
        return res;
	}
}