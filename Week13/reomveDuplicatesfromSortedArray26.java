public class Solution {
    // retain index pointer and lastSame pointer
    // if lastSame is not equal to current element then nums[index++] = lastSame, lastSame = nums[i]
    // be careful about the tail of the array
    // time O(n), space O(1)
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        int lastSame = nums[0];
        for(int i : nums){
            if(i != lastSame){
                nums[index++] = lastSame;
                lastSame = i;
            }
        }
        nums[index++] = lastSame;
        return index;
    }

    // retain one pointer, very simple style
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int i = nums.length > 0? 1 : 0;
        for(int num : nums) {
            if(num > nums[i - 1]) nums[i++] = num;
        }
        return i;
    }
}