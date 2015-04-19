public calss 3SumClosest{
	public int threeSumClosest(int[] num, int target) {
        if(num==null||num.length==0) return 0;
        Arrays.sort(num);
        //持有一个close，每次算一下，就可以找出close，时间复杂度O(n^3)，空间复杂度O(1)
        int close=num[0]+num[1]+num[2];
        for(int i=0;i<num.length-2;i++){
            int a=num[i];
            int lo=i+1,hi=num.length-1;
            while(lo<hi){
                int b=num[lo];
                int c=num[hi];
                if(a+b+c==target) return target;
                else if(a+b+c<target){
                    lo++;
                }else{
                    hi--;
                }
                close=Math.abs(close-target)>Math.abs(a+b+c-target)?a+b+c:close;
            }
        }
        return close;
    }
}