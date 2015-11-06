public static class Tower {
		private int index;
		private Stack<Integer> stack;
		
		public Tower(int index) {
			this.index = index;
			stack = new Stack<Integer>();
		}
		
		public int getIndex() {
			return index;
		}
		
		public void moveTopTo(Tower t) {
			int top = stack.pop();
			t.add(top);
			System.out.println("Move disk: " + top + " from tower " + getIndex() + " to tower " + t.getIndex());
		}

		public void add(int top) {
			if(!stack.isEmpty() && stack.peek() <= top) {
				System.out.println("Can't add to tower.");
			}
			else stack.push(top);
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if(n == 0) return;
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
	
	public static void main(String[] arg) throws Exception {
		int n = 1;
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		for(int i = n; i >= 1; i--)
			towers[0].stack.push(i);
		towers[0].moveDisks(n, towers[2], towers[1]);
	}