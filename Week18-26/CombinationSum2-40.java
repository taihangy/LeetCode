public class Solution {
    // dfs
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> item, int start) {
        if(target < 0) return;
        else if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            item.add(candidates[i]);
            helper(candidates, target - candidates[i], res, item, i + 1);
            item.remove(item.size() - 1);
            if(target <= candidates[i]) break;
        }
    }
}