public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        assert nums != null;
        Arrays.sort(nums);
        int less = Integer.MAX_VALUE;
        int larger = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) return target;
                else if(sum > target) {
                    larger = Math.min(larger, sum - target);
                    r--;
                }
                else {
                    less = Math.min(less, target - sum);
                    l++;
                }
            }
        }
        return larger > less? target - less : target + larger;
    }
}