public class Solution {
    // count sort, time O(n), space O(1)
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int[] count = new int[4];
        int[] aux = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            count[nums[i] + 1]++;
        for(int r = 0; r < 3; r++)
            count[r + 1] += count[r];
        for(int i = 0; i < nums.length; i++)
            aux[count[nums[i]]++] = nums[i];
        for(int i = 0; i < nums.length; i++)
            nums[i] = aux[i];
    }

    // like 3 ways quick sort, one pass
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int j = 0, k = nums.length - 1;
        for(int i = 0; i <= k; i++) {
            if(nums[i] == 0 && i != j) {
                swap(nums, i--, j++);
            }
            else if(nums[i] == 2 && i != k) {
               swap(nums, i--, k--); 
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int lt= 0, gt = nums.length - 1;
        int i = 0;
        while(i <= gt) {
            if(nums[i] < 1) swap(nums, lt++, i++);
            else if(nums[i] > 1) swap(nums, gt--, i);
            else i++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // count sort easy version, two passes
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) num0++;
            else if(nums[i] == 1) num1++;
            else if(nums[i] == 2) num2++;
        }
        for(int i = 0; i < num0; i++) nums[i] = 0;
        for(int i = 0; i < num1; i++) nums[num0 + i] = 1;
        for(int i = 0; i < num2; i++) nums[num0 + num1 + i] = 2;
    }
}