public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> dupInK = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!dupInK.add(nums[i])) return true;
            if(i >= k) dupInK.remove(nums[i - k]);
        }
        return false;
    }
}