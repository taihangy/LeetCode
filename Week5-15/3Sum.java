public class 3Sum{
	public List<List<Integer>> threeSum(int[] num) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        //hashset可以有效的避免重复的list
        HashSet<List<Integer>> set=new HashSet<List<Integer>>(); 
        if(num==null||num.length==0) return res;
        Arrays.sort(num);
        //O(n^3)
        for(int i=0;i<num.length-2;i++){
              int a=num[i];
              int lo=i+1,hi=num.length-1;
              while(lo<hi){
                  int b=num[lo],c=num[hi];
                  if(a+b+c==0){
                      ArrayList<Integer> list=new ArrayList<Integer>();
                      list.add(a);
                      list.add(b);
                      list.add(c);
                      set.add(list);
                      lo++;
                      hi--;
                  }
                  else if(a+b+c<0) lo++;
                  else hi--;
              }
        }
         res.addAll(set);
         return res;
    }
}