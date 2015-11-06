public class Solution {
    /**
    *1. Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, the permutation is sorted in descending order, just reverse it to ascending order and we are done. For example, the next permutation of [3, 2, 1] is [1, 2, 3].
    *2. Find the largest index l greater than k such that nums[k] < nums[l].
    *3. Swap the value of nums[k] with that of nums[l].
    *4. Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1].
    */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        // find the violent elem
        int vio = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                vio = i - 1;
                break;
            }
        }
        if(vio == -1) {
            int i = 0, j = nums.length - 1;
            while(i < j) {
                swap(nums, i++, j--);
            }
        }
        else {
            int swap = -1;
            for(int i = nums.length - 1; i > vio; i--)
                if(nums[i] > nums[vio]) {
                    swap = i;
                    break;
                }
            swap(nums, swap, vio);
            for(int j = vio + 1, k = nums.length - 1; j < k; j++, k--) {
                swap(nums, k, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}