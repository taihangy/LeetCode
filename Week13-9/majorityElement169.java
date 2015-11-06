public class Solution {
    // time complexity O(n), space complexity O(n)
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

    // time complexity O(nlogn), space complexity O(1)
    public int majorityElement(int[] nums) {
        assert nums.length > 0;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Moore voting algorithm, initial a candidate and counter, we look current element x:
    // if counter is zero, set current candidate to  x and counter to 1
    // if counter is not zero, we increase or decrease counter according to whether x is equal to candidate
    // time comx O(n), space comx O(1)
    public int majorityElement(int[] nums) {
        assert nums.length > 0;
        int candidate = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if(candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    // dive and conquer
    // T(n) = T(n / 2) + 2n, T(1) = 1, time comx O(NlogN), space O(logN)
    // first part majority element A, second B, if A==B, then settled, if not, check A and B through entire array to determine the majority element
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return majorityElement(nums, 0, nums.length - 1);
    }
    private int majorityElement(int[] nums, int start, int end) {
        if(start == end) 
            return nums[start];
        
        int first = majorityElement(nums, start, (end + start) / 2);
        int second = majorityElement(nums, (end + start) / 2 + 1, end);
        if(first == second) return first;
        else {
            int countFirst = 0, countSecond = 0;
            for(int i = start; i <= end; i++) {
                if(nums[i] == first) countFirst++;
                if(nums[i] == second) countSecond++;
            }
            return countFirst > countSecond? first : second;
        }
    }

    // recursive version improve, DON'T LET THE OUTLET BE TOO SMALL, IF THEN YOU WILL MAKE THE RECURSION TREE TOO DEEP WHICH CAN SLOW DOWN YOUR SPEED, EVEN STACK OVERFLOW
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int start, int end) {
        if(start + 2 >= end) {
            int major = nums[start], count = 0;
            for(int i = start; i <= end; i++) {
                if(nums[i] == major) count++;
            }
            return count == 1? nums[end] : nums[start]; 
        }
        int mid = (start + end) / 2;
        int leftMaj = helper(nums, start, mid);
        int rightMaj = helper(nums, mid + 1, end);
        if(leftMaj == rightMaj) return leftMaj;
        int count = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] == leftMaj) count++;
        }
        return count > (end - start + 1) / 2? leftMaj : rightMaj;
    }
}