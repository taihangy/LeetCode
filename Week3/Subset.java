public class Subset{
    //非递归解法，每一次新加一个元素，在原有所有的子集中添加元素，再将新的子集加入其中
	public List<List<Integer>> subsets(int[] S){
		ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		if(S==null||S.length==0)
			return res;
		Arrays.sort(S);
		for(int i=0;i<S.length;i++){
			int size=res.size();
			for(int j=0;j<size;j++){
				ArrayList<Integer> elem=new ArrayList<Integer>(res.get(j));
				elem.add(S[i]);
				res.add(elem);
			}
		}
		return res;
	}

    //递归解法，思路与非递归类似，注意递归出口加入空集
	public List<List<Integer>> subsets(int[] num) {
        if(num==null)
            return null;
        Arrays.sort(num);
        return helper(num,num.length-1);
    }
    public ArrayList<List<Integer>> helper(int[] num,int index){
        if(index==-1){
            ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
            ArrayList<Integer> elem=new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        ArrayList<List<Integer>> res=helper(num,index-1);
        int size=res.size();
        for(int i=0;i<size;i++){
          ArrayList<Integer> elem=new ArrayList<Integer>(res.get(i));
          elem.add(num[index]);
          res.add(elem);
        }
        return res;
    }
}