public class Solution {
	public TreeNode nextNode(TreeNode x) {
		if(x.right != null) {
			x = x.right;
			while(x.left != null) {
				x = x.left;
				if(x.left == null) return x;
			}
		}
		else {
			TreeNode parent = x.parent;
			while(parent != null && parent.left != x) {
				x = parent;
				parent = parent.parent;
				if(parent == null) return null;
			}
			return parent;
		}
	}
}