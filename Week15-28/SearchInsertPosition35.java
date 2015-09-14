public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        for(int i = 0; i < nums.length; i++) if(target <= nums[i]) return i;
        return nums.length;
    }
}