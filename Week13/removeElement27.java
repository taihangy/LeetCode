public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] == val){
                nums[i--] = nums[len - 1];
                nums[--len] = -1;
            }
        }
        return len;
    }
}