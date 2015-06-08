public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        return sort(nums);
    }
    private int sort(int[] nums){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
        }
        if(nums.length==2) return max-min;
        int step=(max-min)/(nums.length-1)+1;
        int bucNum=(max-min)/step+1;
        int[] minBuckets=new int[bucNum];
        int[] maxBuckets=new int[bucNum];
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            int local=(int)(bucNum*(1.0*(x-min)/(max-min)));
            if(local==bucNum) local=bucNum-1;
            if(minBuckets[local]==0||minBuckets[local]>x) minBuckets[local]=x;
            if(maxBuckets[local]==0||maxBuckets[local]<x) maxBuckets[local]=x;
        }
        int res=0;
        min=maxBuckets[0];
        for(int i=1;i<bucNum;i++){
            if(minBuckets[i]==0) continue;
            res=Math.max(res,minBuckets[i]-min);
            min=maxBuckets[i];
        }
        return res;
    }
}