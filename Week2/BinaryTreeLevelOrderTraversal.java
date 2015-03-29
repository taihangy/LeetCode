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
        //保存所有level的节点
		List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        //用Queue levelOrderTraversal
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        //lastNum用于表示上一层所加入的节点数量，curNum表示本层加入的节点数量
        //若上一层的已经全部poll，则已经完成将所有上层节点加入
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