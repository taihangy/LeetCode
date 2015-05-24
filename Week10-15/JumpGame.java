public class Solution {
	//空间O(1)，时间复杂度O(N)
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int reach=0;
        for(int i=0;i<=reach&&i<nums.length;i++){
            reach=Math.max(reach,nums[i]+i);
        }
        return reach<nums.length-1?false:true;
    }
}