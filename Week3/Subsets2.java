public class Subsets2{
	public List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        int lastsize=0;
        for(int i=0;i<num.length;i++){
            int size=res.size();
            int start=0;
            if(i>0&&num[i]==num[i-1])
                start=lastsize;
            for(int j=start;j<size;j++){
                ArrayList<Integer> elem=new ArrayList<Integer>(res.get(j));
                elem.add(num[i]);
                res.add(elem);
            }
            lastsize=size;
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> elem=new ArrayList<Integer>(res.get(j));
                elem.add(num[i]);
                res.add(elem);
            }
        }
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> elem=new ArrayList<Integer>(res.get(j));
                elem.add(num[i]);
                res.add(elem);
            }
        }
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>(res);
        res.clear();
        res.addAll(set);
        return res;
    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        if(num==null)
            return null;
        Arrays.sort(num);
        int[] lastSize={0};
        return helper(num,lastSize,num.length-1);
    }
    public ArrayList<List<Integer>> helper(int[] num,int[] lastSize, int index){
        if(index==-1){
            ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
            ArrayList<Integer> elem=new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        ArrayList<List<Integer>> res=helper(num,index-1);
        int size=res.size();
        int start=0;
        if(index>0&&num[index]==num[index-1])
        	start=lastSize[0];
        for(int i=start;i<size;i++){
          ArrayList<Integer> elem=new ArrayList<Integer>(res.get(i));
          elem.add(num[index]);
          res.add(elem);
        }
        lastSize[0]=size;
        return res;
    }
}