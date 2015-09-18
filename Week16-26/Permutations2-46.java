public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> next = new ArrayList<Integer>();
        for(int i : nums) next.add(i);
        res.add(next);
        while(nextPermutation(nums)){
            next = new ArrayList<Integer>();
            for(int i : nums) next.add(i);
            res.add(next);
        } 
        return res;
    }
    private boolean nextPermutation(int nums[]) {
        int vio = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                vio = i - 1;
                break;
            }
        }
        if(vio == -1) {
            Arrays.sort(nums);
            return false;
        }
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
        return true;
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}