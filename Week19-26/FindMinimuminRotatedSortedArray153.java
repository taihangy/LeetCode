public class Solution {
    //binary search O(log n)
    public int findMin(int[] nums) {
        assert nums != null && nums.length > 0;
        int lo = 0, hi = nums.length - 1;
        while(lo != hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else if(nums[mid] < nums[hi]) hi = mid;
        }
        return nums[lo];
    }
}