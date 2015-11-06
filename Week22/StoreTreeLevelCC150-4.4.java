/* Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D,you'll have D linked lists).*/
public  class Solution {
	//Recursive use O(N) for storing data and O(logn) for stack frame
	//Time usage is O(N)
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, res, 0);
		return res;
	}

	private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> res, int level) {
		if(root == null) return;
		LinkedList<TreeNode> list = null;
		if(level == res.size()) {
			list = new LinkedList<TreeNode>();
			res.add(list);
		} else {
			list = res.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, res, level + 1);
		createLevelLinkedList(root.right, res, level + 1);
	}

	//Using BFS which take O(N) space for data storage and O(N) time
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) current.offer(root);
		while(!current.isEmpty()) {
			res.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent : parents) {
				if(parent.left != null) current.offer(parent.left);
				if(parent.right != null) current.offer(parent.right);
			}
		}
		return res;
	}
}