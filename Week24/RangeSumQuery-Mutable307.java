public class NumArray {
    
    class TreeNode {
        private int start;
        private int end;
        private TreeNode left;
        private TreeNode right;
        private int sum;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
    
    private TreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        else {
            TreeNode tn = new TreeNode(start, end);
            if(start == end) tn.sum = nums[start];
            else {
                int mid = start + (end - start) / 2;
                tn.left = buildTree(nums, start, mid);
                tn.right = buildTree(nums, mid + 1, end);
                tn.sum = tn.left.sum + tn.right.sum;
            }
            return tn;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(TreeNode root, int pos, int val) {
        if(root.start == root.end) root.sum = val;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if(pos <= mid) {
                update(root.left, pos, val);
            }
            else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(TreeNode root, int i, int j) {
        if(root.start == i && root.end == j) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if(j <= mid) {
            return sumRange(root.left, i, j);
        }
        else if(i > mid) {
            return sumRange(root.right, i, j);
        }
        else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);