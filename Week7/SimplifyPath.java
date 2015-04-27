public class SimplifyPath {
	public String simplifyPath(String path){
		if(path==null||path.length()==0) return "";
		LinkedList<String> stack=new LinkedList<String>();
		StringBuilder res=new StringBuilder();
		int i=0;
		while(i<path.length()){
			int index=i;
			StringBuilder sb=new StringBuilder();
			if(i<path.length()&&path.charAt(i)!='/'){
				sb.append(path.charAt(i));
				i++;
			}
			if(index!=i){
				String str=sb.toString();
				if(str.equals("..")){
					if(!stack.isEmpty())
						stack.pop();
				}else if (!str.equals(".")){
					stack.push(str);
				}
			}
			i++;
		}
		
		if(!stack.isEmpty())  
        {  
            String[] strs = stack.toArray(new String[stack.size()]);  
            for(int j=strs.length-1;j>=0;j--)  
            {  
              res.append("/"+strs[j]);  
            }  
        }  else
            return "/";  
        return res.toString();
	}
}