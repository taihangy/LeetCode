public class PascalTriangle2{
	public List<Integer> getRow(int rowIndex){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(rowIndex<0) return list;
		list.add(1);
		if(rowIndex==0) return list;
		for(int i=1;i<=rowIndex;i++){
			for(int j=list.size()-2;j>=0;j--){
				list.set(j+1,list.get(j)+list.get(j+1));
			}
			list.add(1);
		}
		return list;
	}
	public List<Integer> getRow2(int rowIndex){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(rowIndex<0) return list;
		list.add(1);
		if(rowIndex==0) return list;
		list.add(1);
		ArrayList<Integer> newlist=list.clone();
		for(int i=1;i<=rowIndex;i++){
			for(int j=newlist.size()-2;j>=0;j--)
				newlist.set(j+1,list.get(j)+list.get(j+1));
			newlist.add(1);
			list=newlist;
		}
		return newlist;
	}
}