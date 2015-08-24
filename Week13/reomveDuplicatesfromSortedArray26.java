public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        int lastSame = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == lastSame){
                continue;
            }
            else{
                nums[index++] = lastSame;
                lastSame = nums[i];
            }
        }
        nums[index] = lastSame;
        return index + 1;
    }
}