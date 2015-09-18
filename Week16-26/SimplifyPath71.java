public String simplifyPath(String path){
		if(path==null||path.length()==0) return "";
		StringBuilder res = new StringBuilder();
		int len = path.length();
		for(int i = 0; i < len; i++) {
		    char c = path.charAt(i);
		    switch(c) {
		        case '/':
		            break;
		        case '.':
		            if(i + 1 < len && path.charAt(i + 1) == '.') {
		                if(res.length() >= 2) {
		                    res.deleteCharAt(res.length() - 1);
		                    res.deleteCharAt(res.length() - 1);
		                }
		            }
		            break;
		        default:
		            res.append('/').append(c);
		            break;
		    }
		}
		return res.length() == 0 ? "/" : res.toString();
	}