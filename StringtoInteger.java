public class StringtoInteger{
	public int atoi(String str) {
		if(str==null) return 0;
		str=str.trim();
		if(str.length()==0) return 0;
		boolean isNeg=false;
		int i=0;
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			i++;
			if(str.charAt(0)=='-')
				isNeg=true;
		}
		int ret=0;
		int digit=0;
		while(i<str.length()){
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
			digit=(int)str.charAt(i)-'0';
			if(isNeg&&ret>-((Integer.MIN_VALUE+digit)/10))
				return Integer.MIN_VALUE;
			else if(!isNeg&&ret>(Integer.MAX_VALUE-digit)/10)
				return Integer.MAX_VALUE;
			ret=10*ret+digit;
			i++;
		}
		return isNeg?-ret:ret;
	}
}