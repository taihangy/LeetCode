public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = max < num ? num : max;
        }
        int[] find = new int[max + 1];
        for(int num : nums) {
            int index = num;
            find[index] = 1;
        }
        int res = 0;
        for(int i = 0; i < find.length; i++) {
            if(find[i] == 0) {
                return i;
            }
        }
        return max + 1;
    }

    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = (len + 1) * len / 2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        res ^= nums.length;
        for(int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}