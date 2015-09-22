public class Solution {
    /**
    * Every time i is greater than last reach find the maximum distance it can 
    * reach now, step++, if it is nums.length - 1 then return
    * Time O(n), Space O(1)
    */
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int steps = 0;
        int reach = 0;
        int lastReach = 0;
        for(int i = 0; i <= reach && i < nums.length; i++) {
            if(i > lastReach) {
                steps++;
                lastReach = reach;
                if(lastReach >= nums.length - 1) break;
            }
            reach = Math.max(reach, nums[i]+i);
        }
        return reach < nums.length - 1? 0 : steps;
    }
}