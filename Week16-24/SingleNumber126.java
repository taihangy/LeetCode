public class Solution {
	// we can use hashmap solution or this solution, because every number xor itself is 0
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) res ^= i;
        return res;
    }
}