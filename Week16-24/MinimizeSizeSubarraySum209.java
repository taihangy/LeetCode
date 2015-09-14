public class Solution {
    // it is easy to think time O(n), space O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0, pre = 0;
        int minLen = nums.length, allSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            sum += elem;
            allSum += elem;
            while(sum >= s) {
                minLen = minLen > i - pre + 1? i - pre + 1 : minLen;
                sum -= nums[pre++];
            }
        }
        return allSum < s ? 0 : minLen;
    }
}