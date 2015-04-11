public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) return res;
        Arrays.sort(candidates);
        ArrayList<Integer> item=new ArrayList<Integer>();
        return helper(candidates,target,res,item,0);
    }
	
	private List<List<Integer>> helper(int[] candidates,int target,ArrayList<List<Integer>> res,ArrayList<Integer> item,int start){
		if(target<0) return res;
		else if(target==0){
			res.add(new ArrayList<Integer>(item));
			return res;
		}
		for(int i=start;i<candidates.length;i++){
			if(i>start&&candidates[i]==candidates[i-1]) continue;
			item.add(candidates[i]);
			helper(candidates,target-candidates[i],res,item,i);
			item.remove(item.size()-1);
			if(target==candidates[i]) break;
		}
		return res;
	}
}