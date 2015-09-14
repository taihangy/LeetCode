public class Solution {
    // HashMap solution, time O(n), space O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length < 2) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                int left = map.get(nums[i]);
                res[0] = left + 1; res[1] = i + 1;
            }
        }
        return res;
    }

    // sort solution, O(nlogn), O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length < 2) return res;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int num1 = nums[i];
            int num2 = nums[j];
            if(num1 + num2 == target) {
                break;
            } 
            else if(num1 + num2 < target) i++;
            else j--;
        }
        for(int k = 0; k < copy.length; k++) {
            if(copy[k] == nums[i]) {
                res[0] = k + 1;
                break;
            }
        }
        for(int k = 0; k < copy.length; k++) {
            if(copy[k] == nums[j] && k + 1 != res[0]) {
                res[1] = k + 1;
                break;
            }
        }
        if(res[0] > res[1]) {
            res[0] ^= res[1];
            res[1] ^= res[0];
            res[0] ^= res[1];
        }
        return res;
    }
    
}
	