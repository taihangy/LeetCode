public class Solution {
    // hashset solution 1, contains duplicate then break
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

    // set.size() == nums.length
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums) set.add(i);
        return set.size() != nums.length;
    }
}