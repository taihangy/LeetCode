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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        inorder(root, target, s1, true);
        inorder(root, target, s2, false);
        
        while(k > 0) {
            if(s1.isEmpty()) {
                res.add(s2.pop());
            } else if(s2.isEmpty()) {
                res.add(s1.pop());
            } else if(s2.peek() - target < target - s1.peek()) {
                res.add(s2.pop());
            } else {
                res.add(s1.pop());
            }
            k--;
        }
        return res;
    }
    
    private void inorder(TreeNode root, double target, Stack<Integer> stack, boolean pre) {
        if(root == null) return;
        inorder(pre? root.left : root.right, target, stack, pre);
        if((pre && root.val > target) || (!pre && root.val <= target)) return;
        stack.push(root.val);
        inorder(pre? root.right : root.left, target, stack, pre);
    }
}

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        Stack<TreeNode> pred = new Stack<TreeNode>();
        
        // initialize the paths for for the predecesor and successor, from closest to farest, O(logN)
        initSuccPath(succ, root, target);
        initPredPath(pred, root, target);
        // if two stacks has the same top element find the predecesor closest to that element, O(logN)
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPred(pred);
        }
        // find k element, O(k)
        while(k-- > 0) {
            if(succ.isEmpty()) {
                res.add(getNextPred(pred));
            }
            else if(pred.isEmpty()) {
                res.add(getNextSucc(succ));
            }
            else {
                double succDiff = (double)(succ.peek().val - target);
                double predDiff = (double)(target - pred.peek().val);
                if(succDiff < predDiff) {
                    res.add(getNextSucc(succ));
                } else {
                    res.add(getNextPred(pred));
                }
            }
        }
        return res;
    }
    
    private void initSuccPath(Stack<TreeNode> succ, TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                succ.push(root);
                break;
            } 
            else if(root.val > target) {
                succ.push(root);
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
    }
    
    private void initPredPath(Stack<TreeNode> pred, TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                pred.push(root);
                break;
            } 
            else if(root.val < target) {
                pred.push(root);
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
    }
    
    private int getNextPred(Stack<TreeNode> pred) {
        TreeNode cur = pred.pop();
        int res = cur.val;
        cur = cur.left;
        while(cur != null) {
            pred.push(cur);
            cur = cur.right;
        }
        return res;
    }
    
    private int getNextSucc(Stack<TreeNode> succ) {
        TreeNode cur = succ.pop();
        int res = cur.val;
        cur = cur.right;
        while(cur != null) {
            succ.push(cur);
            cur = cur.left;
        }
        return res;
    }
}

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>(), succ = new Stack<>();
        initStack(pred, succ, root, target);
        while(k-- > 0){
            if(succ.isEmpty() || !pred.isEmpty() && target - pred.peek().val < succ.peek().val - target){
                list.add(pred.peek().val);
                getPredecessor(pred);
            }
            else{//Since N > k, always have something to add
                list.add(succ.peek().val);
                getSuccessor(succ);
            }
        }
        return list;
    }
    
    private void initStack(Stack<TreeNode> pred, Stack<TreeNode> succ, TreeNode root, double target){
        while(root != null){
            if(root.val <= target){
                pred.push(root);
                root = root.right;
            }
            else{
                succ.push(root);
                root = root.left;
            }
        }
    }
    private void getPredecessor(Stack<TreeNode> st){
        TreeNode node = st.pop();
        if(node.left != null){
            st.push(node.left);
            while(st.peek().right != null)  st.push(st.peek().right);
        }
    }
    private void getSuccessor(Stack<TreeNode> st){
        TreeNode node = st.pop();
        if(node.right != null){
            st.push(node.right);
            while(st.peek().left != null)   st.push(st.peek().left);
        }
    }
}