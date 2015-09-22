public class Solution {
    /**
    * The first pass from left to right
    * The second pass from right tot left, select max value to store
    * Time O(n), Space O(n)
    */
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0) return 0;
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if(ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
            else nums[i] = 1;
        }
        int res = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            int cur = 1;
            if(ratings[i] > ratings[i + 1]) {
                cur = nums[i + 1] + 1;
            }
            res += Math.max(nums[i], cur);
            nums[i] = Math.max(nums[i], cur);
        }
        return res;
    }
}