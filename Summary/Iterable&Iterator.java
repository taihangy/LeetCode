public class A<E> implements Iterable<E> {

	@Override
	public Iterator<E> iterator() {
		return new XXIterator();
	}

	private class XXIterator implements Iterator<E> {
		@Override
		public boolean hasNext() {

		}

		@Override
		public E next() {

		}

		@Override
		public void remove() {
			// usually not implemented
		}
	}

	public static void main(String[] args) {
		A<String> a = new A<String>();
		// following blocks are equal to each other
		for(String s : a) 
			System.out.println(s);

		Iterator<String> iter = a.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
}