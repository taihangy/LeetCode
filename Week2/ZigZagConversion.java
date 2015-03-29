public class ZigZagConversion{
	public String convert(String s,int nRows){
		if(s==null||s.length()==0) return "";
		if(nRows==1) return s;
		StringBuilder sb=new StringBuilder();
		//每一个zigzag含有2*nRow-2个
		int m=2*nRows-2;
		for(int i=0;i<nRows;i++){
			for(int j=i;j<s.length();j+=m){
				sb.append(s.charAt(j));
				//推理出中间的行，每行出了j+m以外还插入了j+m-2*i的元素（当然不能超出s.length()）
				if(i!=0&&i!=nRows-1&&j+m-2*i<s.length())
					sb.append(s.charAt(j+m-2*i));
			}
		}
		return sb.toString();
	}
}