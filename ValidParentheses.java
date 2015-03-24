public class ValidParentheses{
	public boolean isValid(String s){
		if(s==null||s.length()==0) return true;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c1=s.charAt(i);
			if(c1=='('||c1=='['||c1=='{'){
				stack.push(c1);
			}else{
				if(stack.isEmpty()) return false;
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
		if(!stack.isEmpty()) return false;
		else return true;
	}
}