public class HouseRobber{
    //动态规划题，不能连抢两家，因此必须抢nums[i-1]的收入相当于要加上global[i-2]
	public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int N=nums.length;
        int[] local=new int[N+1];
        int[] global=new int[N+1];
        local[0]=0;
        global[0]=0;
        local[1]=nums[0];
        global[1]=nums[0];
        for(int i=2;i<=N;i++){
            local[i]=nums[i-1]+global[i-2];
            global[i]=Math.max(local[i],global[i-1]);
        }
        return global[N];
    }
}