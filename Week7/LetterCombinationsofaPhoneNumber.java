public class LetterCombinationsofaPhoneNumber{
	public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if(digits==null||digits.length()==0) return res;
        helper(digits,0,"",res);
        return res;
    }
    private void helper(String digits,int index,String item,List<String> res){
        if(index>=digits.length()){
            res.add(item);
            return;
        }
        int num=digits.charAt(index)-'0';
        String str=numToString(num);
        if(str!=null){
            for(int i=0;i<str.length();i++){
                helper(digits,index+1,item+str.substring(i,i+1),res);
            }
        }else{
            helper(digits,index+1,item,res);
        }
    }
    private String numToString(int num){
        switch(num){
            case 0:
                return "";
            case 1:
                return "";
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return null;
    }
}