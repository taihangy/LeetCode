public class Solution {
    // in the worst case, every element in array is the same, 
    // and time conplexity is O(n^2)
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(target == nums[mid]) return true;
            // left is sorted
            if(nums[mid] > nums[hi]) {
                if(target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            } 
            // right is sorted
            else if(nums[mid] < nums[hi]) {
                if(target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
            // cannot judge so just hi--
            else {
                hi--;
            }
        }
        return false;
    }
}