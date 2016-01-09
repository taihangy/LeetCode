public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int hi = nums.length - 1, lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int elem = nums[mid];
            if (elem == target) return mid;
            if (elem > nums[lo]) {
                if (target < elem && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            } else if (elem < nums[lo]){
                if (target > elem && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else {
                lo++;
            }
        }
        return -1;
    }
}