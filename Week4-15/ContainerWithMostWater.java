public class ContainerWithMostWater{
    //不知道算不算是动态规划问题
	public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        //保存一个存有最大容积的值
        int global=0;
        int lo=0,hi=height.length-1;
        while(lo<=hi){
            global=Math.max(global,Math.min(height[lo],height[hi])*(hi-lo));
            //判断左右高度，某一边低了，就动低得那边，时间复杂度O(n)
            if(height[lo]<height[hi]) lo++;
            else hi--;
        }
        return global;
    }
}