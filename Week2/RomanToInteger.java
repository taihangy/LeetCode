public class RomanToInteger{
	public int romanToInt(String s){
		if(s==null) return 0;
		//存两个指针
		int sum,pre,cur;
		sum=charToInt(s.charAt(0));
		for(int i=1;i<s.length();i++){
			pre=charToInt(s.charAt(i-1));
			cur=charToInt(s.charAt(i));
			//cur<=pre则sum直接加cur，否则，减去pre后加cur，之后移动指针
			if(cur<=pre)
				sum=sum+cur;
			else
				sum=sum-2*pre+cur;
		}
		return sum;
	}
	//helper function
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