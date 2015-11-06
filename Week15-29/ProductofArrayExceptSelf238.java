public class Solution {
    //time O(n), space O(1), two passes, one from left to right and another from right to left
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // store the product before current number
        for(int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i - 1];
        // store the product after the number
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}