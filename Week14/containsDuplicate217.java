public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> dupDect = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(dupDect.contains(nums[i])) return true;
            else dupDect.add(nums[i]);
        }
        return false;
    }
}