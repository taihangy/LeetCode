public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if(nums[j] + nums[k] + a >= target) {
                    k--;
                }
                else {
                    count += k - j;
                    j++;
                }
            }
        }
        return count;
    }
}