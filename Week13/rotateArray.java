public class Solution {
    //version 1
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int[] rotate = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            rotate[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i]=rotate[i];
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        k = k % nums.length;
        int[] rotate = new int[nums.length];
        System.arraycopy(nums, nums.length - k, rotate, 0, k);
        System.arraycopy(nums, 0, rotate, k, nums.length - k);
        System.arraycopy(rotate, 0, nums, 0, nums.length);
    }
}