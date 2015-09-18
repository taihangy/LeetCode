public class Solution {
    // time O(2logn), space O(1)
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        // search lower boundary
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
                if(mid - 1 < 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                }
                else hi = mid - 1;
            } 
            else if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        // search higher boundary
        lo = 0;
        hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
                if(mid + 1 > nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                }
                else lo = mid + 1;
            } 
            else if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return res;
    }
}