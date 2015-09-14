public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        int times = factorial(nums.length);
        for(int i = 0; i < times; i++) {
            List next = nextPermutation(nums);
            res.add(next);
        }
        return res;
    }
    private int factorial(int length) {
        int res = 1;
        while(length >= 1) {
            res *= length;
            length--;
        }
        return res;
    }
    private List<Integer> nextPermutation(int nums[]) {
        List<Integer> res = new ArrayList<Integer>();
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
        for(int i : nums) res.add(i);
        return res;
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}