public class Subsets2{
    //非递归解法，与Subsets类似，但为了避免重复的元素，当元素与上一个相同时，从上次一加入的新的子集开始加入，避免重复
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

    //HashSet也是一种思路，当然面试的时候用作备用，可以去看看HashSet的实现
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
        //使用addAll方法加入所有子集
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
        //直接构建含有res内所有元素的set
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>(res);
        res.clear();
        res.addAll(set);
        return res;
    }

    //递归解法，注意函数传递是值得传递，所以需要传递reference而不是integer
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