public class Solution {
    // O(nlogn) time, binary search from 1 to n and check if the selected number, then we can throw half
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length - 1;
        int start = 1, end = n;
        while(start != end) {
            int mid = (start + end) / 2;
            int count = 0;
            for(int elem : nums) {
                if(elem <= mid) count++;
            }
            if(count > mid) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}