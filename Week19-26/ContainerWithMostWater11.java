public class Solution {
    public int maxArea(int[] height) {
        assert height != null && height.length >= 2;
        int lo = 0, hi = height.length - 1;
        int maxWater = 0;
        while(lo != hi) {
            int water = Math.min(height[lo], height[hi]) * (hi - lo);
            maxWater = water > maxWater? water : maxWater;
            if(height[lo] <= height[hi]) lo++;
            else hi--;
        }
        return maxWater;
    }
}