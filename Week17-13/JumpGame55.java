public class Solution {
	/**
    * Keep a variable to record the farrest distance it can reach now
    * Time O(n) Space O(1)
    */
    public boolean canJump(int[] nums) {
        if(nums == null) return false;
        if(nums.length == 0) return true;
        int reach = 0;
        for(int i = 0; i<=reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i]+i);
            if(reach >= nums.length - 1) return true;
        }
        return -1;
    }
}s