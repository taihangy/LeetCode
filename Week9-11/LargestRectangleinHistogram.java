public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0) return 0;
        //维护一个高度递增的栈（下标），一旦遇到cur的height小于栈顶，则出栈
        //出栈后判断栈是否为空，若是，则说明该height为最小值
        //若否，则计算该下标到已出栈的栈顶构成的矩形面积，每出栈一个都计算该下标到栈顶的矩形面积，维护max值
        //时间O(n),空间O(n)维护栈
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
        //最后要出栈，应为有可能栈还是非空
        while(!stack.isEmpty()){
            int index=stack.pop();
            int area=stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
            max=Math.max(max,area);
        }
        return max;
    }
}