public class ContainerWithMostWater{
	public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        int global=0;
        int lo=0,hi=height.length-1;
        while(lo<=hi){
            global=Math.max(global,Math.min(height[lo],height[hi])*(hi-lo));
            if(height[lo]<height[hi]) lo++;
            else hi--;
        }
        return global;
    }
}