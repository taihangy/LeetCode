public class strStr{
	public int strStr(String haystack,String needle){
		if(haystack==null) return -1;
		if(haystack.length()<needle.length()) return -1;
		if(needle.length()==0) return 0;
		char[] h=haystack.toCharArray();
		char[] n=needle.toCharArray();
		int index=0;
		for(int j=0;j<=h.length-n.length;j++){
			if(n[0]==h[j]){
				index=j;
				boolean flag=true;
				for(int i=0,k=j;i<n.length;i++,k++){
					if(n[i]!=h[k]){
						flag=false;
						break;
					}
				}
				if(flag) return index;
			}
		}
		return -1;
	}
}