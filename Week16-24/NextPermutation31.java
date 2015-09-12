public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
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
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
                i++; j--;
            }
        }
        else {
            int swap = -1;
            for(int i = nums.length - 1; i > vio; i--)
                if(nums[i] > nums[vio]) {
                    swap = i;
                    break;
                }
            nums[vio] ^= nums[swap];
            nums[swap] ^= nums[vio];
            nums[vio] ^= nums[swap];
            for(int j = vio + 1, k = nums.length - 1; j < k; j++, k--) {
                nums[j] ^= nums[k];
                nums[k] ^= nums[j];
                nums[j] ^= nums[k];
            }
        }
    }
}