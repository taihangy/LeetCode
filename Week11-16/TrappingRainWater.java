public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int sum=0;
        int max=-1;
        int maxIndex=-1;
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max=height[i];
                maxIndex=i;
            }
        }
        int prev=0;
        for(int i=0;i<maxIndex;i++){
            if(height[i]>prev){
                sum+=(maxIndex-i)*(height[i]-prev);
                prev=height[i];
            }
            sum-=height[i];
        }
        prev=0;
        for(int i=height.length-1;i>maxIndex;i--){
            if(height[i]>prev){
                sum+=(i-maxIndex)*(height[i]-prev);
                prev=height[i];
            }
            sum-=height[i];
        }
        return sum;