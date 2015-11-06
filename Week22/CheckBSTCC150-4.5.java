public class Solution {
	public static boolean checkBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		copyBST(root, list);
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i) >= list.get(i + 1)) return false;
		}
		return true;
	}

	private static void copyBST(TreeNode root, List<Integer> list) {
		if(root == null) return;
		copyBST(root.left, list);
		list.add(root.val);
		copyBST(root.right, list);
	}

	private long lastData = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
		if(!isValidBST(root.left)) return false;
		if((long)root.val <= lastData) return false;
		lastData = root.val;
		if(!isValidBST(root.right)) return false;
		return true;
	}
}