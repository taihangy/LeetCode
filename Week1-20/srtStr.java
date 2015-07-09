public class strStr{
	public int strStr(String haystack,String needle){
		//haystack==null显然返回-1
		if(haystack==null) return -1;
		//haystack的长度小于needle时返回-1
		if(haystack.length()<needle.length()) return -1;
		//当needle长度为0时，返回0
		if(needle.length()==0) return 0;
		char[] h=haystack.toCharArray();
		char[] n=needle.toCharArray();
		int index=0;
		for(int j=0;j<=h.length-n.length;j++){
			if(n[0]==h[j]){
				index=j;
				boolean flag=true;
				//一旦某一位不对应flag为false不返回，注意不能破坏j，k=j
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