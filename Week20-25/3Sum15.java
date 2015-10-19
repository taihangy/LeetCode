public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        assert nums != null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if(sum < 0) l++;
                else r--;
            }
        }
        return res;
    }
}