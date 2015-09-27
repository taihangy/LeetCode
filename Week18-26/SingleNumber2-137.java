public class Solution {
    // Time O(2n), Space O(n)
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
    // state transfer
    /** 3 state need two bits a, b, when c comes, it will change from 00,01,10 to next stage, and there is one element appears one or
    * two times, so if 00, there is no such element, 01 and 10 will do the job
    * Time O(n), Space O(1)
    * a b c a b
    * 0 0 0 0 0
    * 0 1 0 0 1
    * 1 0 0 1 0
    * 0 0 1 0 1
    * 0 1 1 1 0
    * 1 0 1 0 0
    * a = a & ~b & ~c | ~a & b & c
    * b = ~a & b & ~c | ~a & b & c
    * a b element
    * 0 0 0
    * 0 1 1
    * 1 0 1
    * element = ~a & b | ~b & a or element = a | b
    */
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