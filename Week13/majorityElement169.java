public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null) return Integer.MAX_VALUE;
        int res = nums[0];
        int threshold = nums.length % 2 == 0? nums.length / 2 : (nums.length - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]) + 1;
                if(count > threshold) {
                    res = nums[i];
                    break;
                }
                else {
                    map.put(nums[i], count);
                }
            }
        }
        return res;
    }
}