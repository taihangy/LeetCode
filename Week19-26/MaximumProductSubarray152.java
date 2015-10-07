public class Solution {
    //concise way
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int maxPos = nums[0], maxNeg = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = maxPos;
            maxPos = Math.max(Math.max(nums[i], nums[i] * maxPos), nums[i] * maxNeg);
            maxNeg = Math.min(Math.min(nums[i], nums[i] * temp), nums[i] * maxNeg);
            res = maxPos > res? maxPos : res;
        }
        return res;
    }

    // more common way to think
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int maxPos = nums[0], maxNeg = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int elem = nums[i];
            if(elem >= 0) {
                maxPos = Math.max(maxPos * elem, elem);
                maxNeg = Math.min(maxNeg * elem, elem);
            }
            else {
                int temp = maxPos;
                maxPos = Math.max(maxNeg * elem, elem);
                maxNeg = Math.min(temp * elem, elem);
            }
            res = maxPos > res? maxPos : res;
        }
        return res;
    }
}