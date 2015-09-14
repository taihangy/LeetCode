public class Solution {
    // recursive method
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return null;
        Arrays.sort(nums);
        return subsets(nums, nums.length - 1);
    }
    private List<List<Integer>> subsets(int[] nums, int index) {
        if(index == -1) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            ArrayList<Integer> elem = new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        List<List<Integer>> res = subsets(nums, index - 1);
        int size = res.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> elem = new ArrayList(res.get(i));
            elem.add(nums[index]);
            res.add(elem);
        }
        return res;
    }

    // same as subset2
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int size = res.size();
            for(int j = 0; j < size; j++) {
                ArrayList<Integer> elem = new ArrayList<Integer>(res.get(j));
                elem.add(nums[i]);
                res.add(elem);
            }
        }
        return res;
}