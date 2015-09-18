public class Solution {
    // we can use hashmap solution or this solution, because every number xor itself is 0
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) res ^= i;
        return res;
    }

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(int i = 0; i < nums.length; i++)
            if(map.get(nums[i]) != 2) return nums[i];
        return -1;
    }
}