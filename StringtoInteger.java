public class StringtoInteger{
	public int atoi(String str) {
		//需要考虑很多情况
		if(str==null) return 0;
		str=str.trim();
		//排除全是空格的情况
		if(str.length()==0) return 0;
		//判断正负号
		boolean isNeg=false;
		int i=0;
		//若为有符号数则isNeg赋值，i从第一个开始，否则从0开始
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			i++;
			if(str.charAt(0)=='-')
				isNeg=true;
		}
		int ret=0;
		int digit=0;
		while(i<str.length()){
			//若不是数字，则跳过
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
			//是数字则计算
			digit=(int)str.charAt(i)-'0';
			//判断是否overflow
			if(isNeg&&ret>-((Integer.MIN_VALUE+digit)/10))
				return Integer.MIN_VALUE;
			else if(!isNeg&&ret>(Integer.MAX_VALUE-digit)/10)
				return Integer.MAX_VALUE;
			ret=10*ret+digit;
			i++;
		}
		//返回时注意正负号
		return isNeg?-ret:ret;
	}
}