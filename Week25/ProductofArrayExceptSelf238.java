public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] res =new int[n];
        int[] product = new int[n];
        product[0] = nums[0];
        for (int i = 1; i < n; i++) {
            product[i] = nums[i] * product[i - 1];
        }
        int[] revProduct = new int[n];
        revProduct[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            revProduct[i] = nums[i] * revProduct[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) res[0] = revProduct[1];
            else if (i == n - 1) res[n - 1] = product[n - 2];
            else res[i] = product[i - 1] * revProduct[i + 1];
        }
        return res;
    }
}