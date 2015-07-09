public class EvaluateReversePolishNotation{
	if(tokens==null||tokens.length==0) return 0;
        LinkedList<Integer> stack=new LinkedList<Integer>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                if(stack.size()>=2){
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(num2+num1);
                }else {
                    return 0;
                }
            }else if(tokens[i].equals("-")){
                if(stack.size()>=2){
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(num2-num1);
                }else {
                    return 0;
                }
            }else if(tokens[i].equals("*")){
                if(stack.size()>=2){
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(num2*num1);
                }else {
                    return 0;
                }
            }else if(tokens[i].equals("/")){
                if(stack.size()>=2){
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(num2/num1);
                }else {
                    return 0;
                }
            } else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        if(stack.size()!=1) return 0;
        else return stack.pop();
}