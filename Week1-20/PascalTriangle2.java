public class PascalTriangle2{
	public List<Integer> getRow(int rowIndex){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(rowIndex<0) return list;			//注意特殊情况判断
		list.add(1);						//当rowIndex为0时，直接返回
		if(rowIndex==0) return list;
		for(int i=1;i<=rowIndex;i++){		//当rowIndex>=1时
			for(int j=list.size()-2;j>=0;j--){		//去头尾的1，list的size需要大于等于2
				list.set(j+1,list.get(j)+list.get(j+1));//从倒数第二个开始，向前重新计算
			}
			list.add(1);					//添加最后一个1
		}
		return list;
	}
	public List<Integer> getRow2(int rowIndex){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(rowIndex<0) return list;
		list.add(1);
		if(rowIndex==0) return list;
		list.add(1);
		ArrayList<Integer> newlist=list.clone();//extra space
		for(int i=1;i<=rowIndex;i++){
			for(int j=newlist.size()-2;j>=0;j--)
				newlist.set(j+1,list.get(j)+list.get(j+1));//每一次都从list里取number赋值给newlist
			newlist.add(1);
			list=newlist; //将newlist赋值给list，作为下一次的参考
		}
		return newlist;
	}
}