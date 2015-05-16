public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0) return 0;
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int max=0;
        int i;
        for(i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int index=stack.pop();
                int area=stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
                max=Math.max(max,area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            int area=stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
            max=Math.max(max,area);
        }
        return max;
    }
}