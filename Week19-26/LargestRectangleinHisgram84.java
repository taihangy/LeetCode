public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                int area = stack.isEmpty()? i * height[index] : (i - stack.peek() - 1) * height[index];
                max = max < area? area : max;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int area = stack.isEmpty()? height.length * height[index] : (height.length -stack.peek() - 1) * height[index];
            max = max < area? area : max;
        }
        return max;
    }

    // using stack a more concise way
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int max = 0, length = height.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= length; i++) {
            int h = i == length? 0 : height[i];
            if(stack.isEmpty() || h > height[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                max = Math.max(max, height[top] * (stack.isEmpty()? i : i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }

    //Dive and conquer, left max or right or comtain m, m+1 and expand to left and right
    // T(n) = T(n/2) + O(n), so Time O(nlogn), space O(1)
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        return maxArea(height, 0, height.length - 1);
    }
    
    private int maxArea(int[] height, int l, int r) {
        if(l == r) return height[l];
        int m = (l + r) / 2;
        int area = maxArea(height, l, m);
        area = Math.max(area, maxArea(height, m + 1, r));
        area = Math.max(area, maxCombine(height, l, m, r));
        return area;
    }
    
    private int maxCombine(int[] height, int l, int m, int r) {
        int i = m, j = m + 1;
        int area = 0;
        int h = Math.min(height[i], height[j]);
        while(i >= l && j <= r) {
            h = Math.min(h, Math.min(height[i], height[j]));
            area = Math.max(area, h * (j - i + 1));
            if(i == l) j++;
            else if(j == r) i--;
            else {
                if(height[i - 1] > height[j + 1]) i--;
                else j++;
            }
        }
        return area;
    }
}