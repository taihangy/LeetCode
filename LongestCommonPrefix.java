public class LongestCommonPrefix{
	public String longestCommonPrefix(String[] strs){
		if(strs==null||strs.length==0) return "";
		if(strs.length==1) return strs[0];
		StringBuilder sb=new StringBuilder();
		boolean flag=true;
		int index=0;
		while(flag){
			for(int i=0;i<strs.length;i++){
				if(strs[0].length()-1-index>=0&&strs[i].length()-1-index>=0){
					if(strs[0].charAt(index)!=strs[i].charAt(index)){
						flag=false;
						break;
					}
				}else{
					flag=false;
					break;
				}
			}
			if(flag){
				sb.append(strs[0].charAt(index++));
			}
		}
		return sb.toString();
	}
}