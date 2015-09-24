public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n > 45 || n < 1 || k <= 0) return res;
        helper(k, n, res, new ArrayList<Integer>(), 1, new boolean[10]);
        return res;
    }
    
    private void helper(int k, int n, List<List<Integer>> res, List<Integer> item, int start, boolean[] marked) {
        if(k == 0 && n != 0) return;
        else if(k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < 10; i++) {
            if(!marked[i]) {
                marked[i] = true;
                item.add(i);
                helper(k - 1, n - i, res, item, i + 1, marked);
                item.remove(item.size() - 1);
                marked[i] = false;
                if(n <= i) break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n > 45 || n < 1 || k <= 0) return res;
        helper(k, n, res, new ArrayList<Integer>(), 1);
        return res;
    }
    
    private void helper(int k, int n, List<List<Integer>> res, List<Integer> item, int start) {
        if(k == 0 && n != 0) return;
        else if(k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < 10; i++) {
            item.add(i);
            helper(k - 1, n - i, res, item, i + 1);
            item.remove(item.size() - 1);
            if(n <= i) break;
        }
    }
}