public class  UniqueBinarySearchTrees2{
	public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    private ArrayList<TreeNode> helper(int start,int end){
        ArrayList<TreeNode> res=new ArrayList<TreeNode>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            ArrayList<TreeNode> leftTree=helper(start,i-1);
            ArrayList<TreeNode> rightTree=helper(i+1,end);
            for(int j=0;j<leftTree.size();j++){
                for(int k=0;k<rightTree.size();k++){
                    TreeNode root=new TreeNode(i);
                    root.left=leftTree.get(j);
                    root.right=rightTree.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}