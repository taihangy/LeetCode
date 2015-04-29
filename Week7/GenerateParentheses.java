public class GenerateParentheses{
	//recursive version
	//先左后右，当左括号数量小于右括号时返回，两者都为0时加入
	//http://blog.csdn.net/linhuanmars/article/details/19873463
	//卡特兰数的解法再去看看
	public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        if(n<=0) return res;
        helper(n,n,"",res);
        return res;
    }
    private void helper(int l,int r,String item,List<String> res){
        if(r<l)
            return;
        if(l==0&&r==0){
            res.add(item);
            return;
        }
        if(l>0)
            helper(l-1,r,item+"(",res);
        if(r>0)
            helper(l,r-1,item+")",res);
    }
}