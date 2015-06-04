/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        List<TreeLinkNode> list=new ArrayList<TreeLinkNode>();
        list.add(root);
        helper(list);
    }
    private void helper(List<TreeLinkNode> lastList){
        if(lastList.isEmpty()||lastList.size()==0) return;
        int size=lastList.size();
        List<TreeLinkNode> curList=new ArrayList<TreeLinkNode>();
        for(int i=0;i<size;i++){
            TreeLinkNode node=lastList.get(i);
            if(i==size-1) node.next=null;
            else node.next=lastList.get(i+1);
            if(node.left!=null) curList.add(node.left);
            if(node.right!=null) curList.add(node.right);
        }
        helper(curList);
    }
}