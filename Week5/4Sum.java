public class 4Sum{
	public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        if (num==null||num.length==0) return res;
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            for(int j=i+1;j<num.length-2;j++){
                int lo=j+1,hi=num.length-1;
                int a=num[i],b=num[j];
                while(lo<hi){
                    int c=num[lo],d=num[hi];
                    if(a+b+c+d==target){
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        set.add(list);
                        lo++;
                        hi--;
                    }
                    else if(a+b+c+d<target) lo++;
                    else hi--;
                }
            }
        }
        res.addAll(set);
        return res;
    }
}