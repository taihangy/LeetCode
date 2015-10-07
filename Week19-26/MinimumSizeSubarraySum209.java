public class Solution {
    //time O(n)
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0, min = 0;
        for(int i = 0, pre = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                if(min == 0) min = i - pre + 1;
                else min = min > i - pre + 1? i - pre + 1 : min;
                sum -= nums[pre++];
            }
        }
        return min;
    }

    //time O(nlogn)
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
        for(int i = 0; i < sum.length; i++) {
            int end = binarySearch(i, sum.length - 1, sum[i] + s, sum);
            if(end == sum.length) break;
            min = min > end - i? end - i : min;
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sum) {
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(sum[mid] >= key) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}