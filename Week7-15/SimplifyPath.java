public class SimplifyPath {
	public String simplifyPath(String path){
		if(path==null||path.length()==0) return "";
		//存储有用路径
		LinkedList<String> stack=new LinkedList<String>();
		StringBuilder res=new StringBuilder();
		int i=0;
		while(i<path.length()){
			int index=i;
			StringBuilder sb=new StringBuilder();
			//跳过所有/
			if(i<path.length()&&path.charAt(i)!='/'){
				sb.append(path.charAt(i));
				i++;
			}
			//如果相等，说明有都是/，若不相等说明有有用信息
			//若果是..则pop，返回上一层，若不是.则push，若是.则忽略
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
        	//linkedlist变成array的方法，new String[size];
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