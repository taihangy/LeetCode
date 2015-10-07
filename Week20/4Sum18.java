public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        assert nums != null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while(l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(target == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l + 1] == nums[l]) l++;
                        while(l < r && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    }
                    else if(target < sum) r--;
                    else l++;
                }
            }
        }
        return res;
    }
}