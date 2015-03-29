public class CountandSay{
	public String countAndSay(int n){
		if(n<=0) return "";
		String ret="1";
		//i从1到n
		for(int i=1;i<n;i++){
			int count=1;
			StringBuilder sb=new StringBuilder();
			for(int j=1;j<ret.length();j++){
				//当一直重复时，统计重复“数字”的个数
				if(ret.charAt(j-1)==ret.charAt(j))
					count++;
				else{
					//当不重复时，答应“个数”以及“数字”
					sb.append(count);
					sb.append(ret.charAt(j-1));
					count=1;
				}
			}
			//若结尾前重复（没有不一样的出现），则打印重复“个数”以及“数字”
			//若出现一个不一样的，则打印“1”+数字
			sb.append(count);
			sb.append(ret.charAt(ret.length()-1));
			ret=sb.toString();
		}
		return ret;
	}
}