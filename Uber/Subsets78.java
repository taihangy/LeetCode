public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> copy = new ArrayList<Integer>(res.get(j));
                copy.add(elem);
                res.add(copy);
            }
        }
        return res;
    }
}