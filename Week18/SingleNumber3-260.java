public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return new int[2];
        int[] res = new int[2];
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            if(!countMap.containsKey(elem)) {
                countMap.put(elem, 1);
            } else {
                countMap.put(elem, countMap.get(elem) + 1);  
            }
        }
        for(int i = 0, index = 0; i < nums.length; i++) {
            int elem = nums[i];
            if(countMap.get(elem) == 1) res[index++] = elem;
        }
        return res;
    }
}

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return new int[2];
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        // negate diff, if at zero position diff is 0, it will turn to 1, then add 1, it will turn to zero, and moving forward
        // until it comes to a position that ~d is not 1, which means d is one
        diff &= -diff;
        int[] res = {0, 0};
        for(int num : nums) {
            if((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}