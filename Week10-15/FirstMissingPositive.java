public class Solution {
    //把nums[0]=1,nums[1]=2，....这样就可以验证哪个位置上的是不连续的
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        for(int i=0;i<nums.length;i++){
            //注意当nums[nums[i]-1]=nums[i]时就要跳过，否则会死循环
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
        //如果都正确，则说明是超出最大值1的数字
        return nums.length+1;
    }
}