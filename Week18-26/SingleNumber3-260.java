public class Solution {
    // Time O(2n), Space O(n)
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
        // negate diff, if at zero position of nums diff is 0, it will turn to 1, then add 1, it will turn to zero, and moving forward
        // until it comes to a position that ~d is not 1, which means d is one
        // 设a, b 是那两个数，a和b肯定有一位是不同的，异或后那一位肯定是1，因此我们要找到那个从右边数起第一个1，diff &= -diff
        diff &= -diff;
        // divide into two parts, every pair number at that diff position are either 1 or 0, so we will find them respectively
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