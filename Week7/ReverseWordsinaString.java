public class ReverseWordsinaString{
	public String reverseWords(String s) {
        if(s==null||s.length()==0) return "";
        s=s.trim();
        String[] strs=s.split("\\s+");
        StringBuilder res=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if(i==0) res.append(strs[i]);
            else res.append(strs[i]+" ");
        }
        return res.toString();
    }
}