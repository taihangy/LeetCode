public class RestoreIPAddresses{
	public List<String> restoreIpAddresses(String s){
		List<String> res=new ArrayList<String>();
		if(s==null||s.length()==0||s.length()>12) return res;
		helper(s,0,1,"",res);
		return res;
	}
	private void helper(String s,int index,int segment,String item,List<String> res){
		if(index>=s.length()) return;
		if(segment==4){
			String str=s.substring(index);
			if(isValidIP(str)){
				res.add(item+"."+str);
			}
			return；
		}
		for(int i=1;i<4&&(index+i)<=s.length();i++){
			String str=s.substring(index,index+i);
			if(isValidIP(str)){
				if(segment==1){
					helper(s,index+i,segment+1,str,res);
				}
				else{
					helper(s,index+i,segment+1,item+"."+str,res);
				}
			}
		}
	}
	private boolean isValidIP(String str){
		if(str==null||str.length()<1||str.length()>3) return false;
		int num=Integer.parseInt(str);
		if(str.charAt(0)=='0'&&str.length()>1) return false;
		if(num<0||num>255) return false;
		return true;
	}
}