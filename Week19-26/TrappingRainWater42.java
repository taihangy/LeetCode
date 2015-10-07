public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
        int water = 0;
        int max = -1, maxIndex = -1;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int prev = 0;
        for(int i = 0; i < maxIndex; i++) {
            if(height[i] > prev) {
                water += (maxIndex - i) * (height[i] - prev);
                prev = height[i];
            }
            water -= height[i];
        }
        prev = 0;
        for(int i = height.length - 1; i > maxIndex; i--) {
            if(height[i] > prev) {
                water += (i - maxIndex) * (height[i] - prev);
                prev = height[i];
            }
            water -= height[i];
        }
        return water;
    }
}