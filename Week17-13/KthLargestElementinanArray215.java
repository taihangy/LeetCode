public class Solution {
    /**
    * Using heap sort, it can delete max/min quickly, so just delete k times
    * Time O(nlogn), Space O(n) - auxiliary array
    */
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0) return -1;
        int[] newNums = new int[nums.length + 1];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        return sort(newNums, k);
    }
    private int sort(int[] nums, int k) {
        int N = nums.length - 1;
        for(int i = N/2; i >= 1; i--) sink(nums, i, N);
        int count = N - k + 1;
        while(N > count) {
            exch(nums, 1, N--);
            sink(nums, 1, N);
        }
        return nums[1];
    }
    private void sink(int[] nums, int i, int N) {
        while(2*i <= N) {
            int j = 2*i;
            if(j < N && less(nums, j, j+1)) j++;
            if(less(nums, i, j)) exch(nums, i, j);
            else break;
            i = j;
        }
    }
    private void exch(int[] nums, int i, int j) {
        nums[i] ^= nums[j]; nums[j] ^= nums[i]; nums[i] ^= nums[j];
    }
    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }
}