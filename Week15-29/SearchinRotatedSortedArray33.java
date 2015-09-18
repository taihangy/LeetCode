public class Solution {
    // time O(log n), space O(1), same as 2
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[lo]) {
                if(target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}