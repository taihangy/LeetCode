public class CountandSay{
	public String countAndSay(int n){
		if(n<=0) return "";
		String ret="1";
		for(int i=1;i<n;i++){
			int count=1;
			StringBuilder sb=new StringBuilder();
			for(int j=1;j<ret.length();j++){
				if(ret.charAt(j-1)==ret.charAt(j))
					count++;
				else{
					sb.append(count);
					sb.append(ret.charAt(j-1));
					count=1;
				}
			}
			sb.append(count);
			sb.append(ret.charAt(ret.length()-1));
			ret=sb.toString();
		}
		return ret;
	}
}