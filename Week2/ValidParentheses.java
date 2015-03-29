public class ValidParentheses{
	public boolean isValid(String s){
		if(s==null||s.length()==0) return true;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c1=s.charAt(i);
			//若为左括号则加入stack
			if(c1=='('||c1=='['||c1=='{'){
				stack.push(c1);
			}else{
				//否则先判断stack是否为空
				if(stack.isEmpty()) return false;
				//不为空时，判断是否相匹配
				char c2=stack.pop();
				switch(c1){
					case ')':
						if(c2!='(') return false;
						break;
					case ']':
						if(c2!='[') return false;
						break;
					case '}':
						if(c2!='{') return false;
						break;
				} 
			}
		}
		//最后判断是否还有还未pop的左括号
		if(!stack.isEmpty()) return false;
		else return true;
	}
}