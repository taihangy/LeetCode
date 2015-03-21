public class ExcelSheetColumnNumber{
	public int titleToNumber(String s){
		int len=s.length();
		char[] chars=s.toCharArray();
		int digit=0;
		int sum=0;
		for(int i=0;i<len;i++){
			digit=(int)(chars[i]-'A')+1;
			sum=sum*26+digit;
		}
		return sum;
	}
}