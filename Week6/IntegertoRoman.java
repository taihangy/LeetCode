public class IntegertoRoman{
	public String intToRoman(int num){
		if(n<1||n>3999) return "";
		ArrayList<Integer> digits=new ArrayList<Integer>();
		StringBuilder res=new StringBuilder();
		int digit=1000;
		while(digit>0){
			digits.add(num/digit);
			num%=digit;
			digit/=10;
		}
		res.append(convert(digits.get(0),'M',' ',' '));
		res.append(convert(digits.get(1),'C','D','M'));
		res.append(convert(digits.get(2),'X','L','C'));
		res.append(convert(digits.get(3),'I','V','X'));
		return res.toString();
	}
	private String convert(int digit,char one,char five,char ten){
		StringBuilder res=new StringBuilder();
		switch(digit){
			case 9:
				res.append(one);
				res.append(ten);
				break;
			case 8:
			case 7:
			case 6:
			case 5:
				res.append(five);
				for(int i=5;i<digit;i++)
					res.add(one);
				break;
			case 4:
				res.append(one);
				res.append(five);
				break;
			case 3:
			case 2:
			case 1:
				for(int i=0;i<digit;i++)
					res.add(one);
				break;
			default:
				break；
		}
		return res.toString();
	}
}