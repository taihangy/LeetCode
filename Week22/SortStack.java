/*Sort stack, use only one stack*/
public calss Solution {
	//Time O(n), space O(n)
	public Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> aux = new Stack<Integer>();
		while(!s.isEmpty()) {
			int elem = s.pop();
			while(!aux.isEmpty() && aux.peek() > elem) {
				s.push(aux.pop());
			}
			aux.push(elem);
		}
		return aux;
	}
}