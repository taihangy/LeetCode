public class Solution {
    // treat duplicate as special number, like it has there 5, we can put 1 or 2 or 3 into it, in normal case we can just put it into res
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ) {
            int count = 0;
            while(i + count < nums.length && nums[i + count] == nums[i]) count++;
            int size = res.size();
            for(int j = 0; j < size; j++) {
                List<Integer> elem = new ArrayList<Integer>(res.get(j));
                for(int k = 0; k < count; k++) {
                    elem.add(nums[i]);
                    res.add(new ArrayList<Integer>(elem));
                }
            }
            i += count;
        }
        return res;
    }

    // use hashset it an easier way for programmer
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
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
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;
    }
}