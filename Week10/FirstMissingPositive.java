public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=nums.length&&nums[i]>0&&nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}