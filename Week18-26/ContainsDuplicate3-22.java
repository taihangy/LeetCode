public class Solution {
    // TreeSet O(tlogk), space O(k), summary respectively    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Integer floor = values.floor(nums[i] + t);
            Integer ceil = values.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            values.add(nums[i]);
            if (i >= k) {
                values.remove(nums[i - k]);
            }
        }

        return false;
    }
}