class MinStack{
	//use ArrayList
	ArrayList<Integer> stack=new ArrayList<Integer>();
    ArrayList<Integer> min=new ArrayList<Integer>();
    
    public void push(int x) {
        stack.add(x);
        if(min.isEmpty()||min.get(min.size()-1)>=x)
            min.add(x);
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int elem=stack.remove(stack.size()-1);
        if(!min.isEmpty()&&elem<=min.get(min.size()-1))
            min.remove(min.get(min.size()-1));
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return  stack.get(stack.size()-1);
    }

    public int getMin() {
        if(min.isEmpty()) return 0;
        return min.get(min.size()-1);
    }

    //use primitive data structure
    int[] stack=new int[1];
	int[] minStack=new int[1];
	int N=0;
	int M=0;

	private boolean stackIsEmpty(){
		return N==0;
	}

	private boolean minStackIsEmpty(){
		return M==0;
	}

	//需要根据长度增减重新构造array
	private void stackResize(int len){
		int aux[]=new int[len];
		for(int i=0;i<N;i++)
			aux[i]=stack[i];
		stack=aux;
	}

	private void minStackResize(int len){
		int aux[]=new int[len];
		for(int i=0;i<M;i++)
			aux[i]=minStack[i];
		minStack=aux;
	}

	public void push(int x){
		if(N==stack.length) stackResize(2*stack.length);
		stack[N++]=x;
		if(minStackIsEmpty()||minStack[M-1]>=x){
			if(M==minStack.length) minStackResize(2*minStack.length);
			minStack[M++]=x;
		}
	}

	public void pop(){
		if(stackIsEmpty()) return;
		if(N>0&&N==stack.length/4) stackResize(stack.length/2);
		int elem=stack[--N];
		if(!minStackIsEmpty()&&elem<=minStack[M-1]){
			M--;
			if(M==minStack.length/4) minStackResize(minStack.length/2);
		}
	}

	public int top(){
		if(stackIsEmpty()) return 0;
		return stack[N-1];
	}
	public int getMin(){
		if(minStackIsEmpty()) return 0;
		return minStack[M-1];
	}
}