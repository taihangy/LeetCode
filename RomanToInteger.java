public class RomanToInteger{
	public int romanToInt(String s){
		if(s==null) return 0;
		int sum,pre,cur;
		sum=charToInt(s.charAt(0));
		for(int i=1;i<s.length();i++){
			pre=charToInt(s.charAt(i-1));
			cur=charToInt(s.charAt(i));
			if(cur<=pre)
				sum=sum+cur;
			else
				sum=sum-2*pre+cur;
		}
		return sum;
	}

	private int charToInt(char c){
		int x=0;
		switch(c){
			case 'M':
				x=1000;
				break;
			case 'D':
				x=500;
				break;
			case 'C':
				x=100;
				break;
			case 'L':
				x=50;
				break;
			case 'X':
				x=10;
				break;
			case 'V':
				x=5;
				break;
			case 'I':
				x=1;
				break;
		}
		return x;
	}
}