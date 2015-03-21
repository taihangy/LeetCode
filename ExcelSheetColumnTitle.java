public class ExcelSheetColumnTitle{
	public String convertToTitle(int n) {
		if(n<=0) return null;
		StringBuilder sb=new StringBuilder();
		while(n>0){
			char character=(char)((n-1)%26+'A');
			sb.insert(0,character);
			n=(n-1)/26;
		}
		return sb.toString();
	}
}