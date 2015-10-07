public class Solution {
    public int findPeakElement(int[] nums) {
        // binary search
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if(nums[mid] <= nums[mid - 1]) hi = mid;
            else lo = mid;
        }
        return nums[lo] > nums[hi]? lo : hi;
    }
}