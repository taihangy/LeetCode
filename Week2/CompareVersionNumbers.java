public class CompareVersionNumbers{
	public int compareVersion(String version1,String version2){
		//注意"."在正则表达式中又特殊含义，因此要用"\\."来转义表达
		//题意要理解，2.5.1.1>2.5.1
		String[] str1=version1.split("\\.");
		String[] str2=version2.split("\\.");
		int len=str1.length<str2.length?str1.length:str2.length;
		int i,m,n;
		for(i=0;i<len;i++){
			m=Integer.parseInt(str1[i]);
			n=Integer.parseInt(str2[i]);
			if(m>n) return 1;
			if(m<n) return -1;
		}
		if(str1.length<str2.length){
			while(i<str2.length){
				n=Integer.parseInt(str2[i]);
				if(n>0)
					return -1;
				i++;
			}
		}else if(str1.length>str2.length){
			while(i<str1.length){
				m=Integer.parseInt(str1[i]);
				if(m>0)
					return 1;
				i++;
			}
		}
		return 0;
	}
}