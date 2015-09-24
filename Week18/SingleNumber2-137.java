public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 1) return nums[i];
        }
        return Integer.MIN_VALUE;
    }
}

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int a = 0, b = 0;
        for(int c : nums) {
            int tempA = (a & ~b & ~c) | (~a & b & c);
            b = (~a & b & ~c) | (~a & ~b & c);
            a = tempA;
        }
        return a | b;
    }
}