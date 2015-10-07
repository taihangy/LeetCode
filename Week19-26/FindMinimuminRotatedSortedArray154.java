public class Solution {
    // the worst case would be O(n), every element in the array is same.
    public int findMin(int[] nums) {
        assert nums != null && nums.length > 0;
        int lo = 0, hi = nums.length - 1;
        while(lo != hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else if(nums[mid] < nums[hi]) hi = mid;
            else hi -= 1;
        }
        return nums[lo];
    }
}