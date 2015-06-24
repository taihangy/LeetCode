public class Solution {
    //buckets sort
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


    // 3 way quick sort version (improved MSD)
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        sort(nums,0,nums.length-1,1);
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>max) max=nums[i]-nums[i-1];
        }
        return max;
    }
    
    private static void sort(int[] nums,int lo,int hi,int d){
        if(hi<=lo||d>4) return;
        int lt=lo,gt=hi;
        int v=numAtD(nums[lo],d);
        int i=lo+1;
        while(i<=gt){
            int t=numAtD(nums[i],d);
            if(t>v) exch(nums,i,gt--);
            else if(t<v) exch(nums,i++,lt++);
            else i++;
        }
        sort(nums,lo,lt-1,d);
        sort(nums,lt,gt,d+1);
        sort(nums,gt+1,hi,d);
    }
    
    private static void exch(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private static int numAtD(int num,int d){
        int mask=((1<<31)>>31)>>>24;
        return (num>>(4-d)*8)&mask;
    }


    // LSD version
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        sort(nums,4);
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>max) max=nums[i]-nums[i-1];
        }
        return max;
    }
    
    private static void sort(int[] nums,int W){
        int N=nums.length;
        int R=256;
        int[] aux=new int[N];
        for(int d=W;d>=1;d--){
            int[] count=new int[R+1];
            for(int i=0;i<N;i++)
                count[numAtD(nums[i],d)+1]++;
            for(int r=0;r<R;r++)
                count[r+1]+=count[r];
            for(int i=0;i<N;i++)
                aux[count[numAtD(nums[i],d)]++]=nums[i];
            for(int i=0;i<N;i++)
                nums[i]=aux[i];
        }
    }

    private static int numAtD(int num,int d){
        int mask=((1<<31)>>31)>>>24;
        return (num>>>(4-d)*8)&mask;
    }
}