public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int N = nums.length;
        for(int i = 1; i < N; i++) {
            if((i % 2 == 1 && nums[i - 1] > nums[i]) ||
               (i % 2 == 0 && nums[i - 1] < nums[i])) {
                   int t = nums[i];
                   nums[i] = nums[i - 1];
                   nums[i - 1] = t;
               }
        }
    }
}