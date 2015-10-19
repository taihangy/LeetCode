public class ExcelSheetColumnTitle{
	public String convertToTitle(int n) {
		if(n<=0) return null;
		StringBuilder sb=new StringBuilder();
		while(n>0){
			//注意既然要加'A'则需要(n-1)%26
			char character=(char)((n-1)%26+'A');
			sb.insert(0,character);
			//大于26则需要进位
			n=(n-1)/26;
		}
		return sb.toString();
	}
} 