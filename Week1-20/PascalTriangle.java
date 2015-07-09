public class PascalTriangle{
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> retlist=new ArrayList<List<Integer>>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(numRows==0) return retlist;
		list.add(1);
		retlist.add(list);
		if(numRows==1) return retlist;
		//numRows从2开始
		for(int i=1;i<numRows;i++){
			ArrayList<Integer> newlist=new ArrayList<Integer>();
			newlist.add(1);
			for(int j=1;j<i;j++){
				newlist.add(list.get(j)+list.get(j-1));
			}
			newlist.add(1);
			retlist.add(newlist);
			list=newlist;
		} 
		return retlist;
	}
}