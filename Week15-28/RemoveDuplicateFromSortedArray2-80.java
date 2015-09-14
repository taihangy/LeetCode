public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        boolean flag = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[index] && !flag) {
                nums[++index] = nums[i];
                flag = true;
            } 
            else if(nums[i] != nums[index]) {
                nums[++index] = nums[i];
                flag = false;
            }
        }
        return index + 1;
    }
}