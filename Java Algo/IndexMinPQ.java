/** IndexMinPQ
* if we don't need changeKey, delete methods we don't have to create qp
*/
public class IndexMinPQ<Key extends Comparable<Key>> {
	private int N; //number of element on PQ
	private int[] pq; //binary heap using 1-based indexing
	private int[] qp; //inverse: qp[pq[i]] = i = pq[qp[i]]
	private Key[] keys; //items with priorities

	public IndexMinPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for(int i = 0; i <= maxN; i++) qp[i] = -1;
	}
	
	public int size() {return N;}

	public boolean isEmpty() {return N == 0;}

	public boolean contains(int k) {return qp[k] != -1;}


	//Associates key with index i.
	public void insert(int k, Key key) {
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}

	//Removes a minimum key and returns its associated index.
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N + 1]] = null;
		qp[pq[N + 1]] = -1;
		return indexOfMin;
	}

	//Returns an index associated with a minimum key.
	public int minIndex() {
		return pq[1];
	}

	//Returns a minimum key.
	public Key minKey() {
		return keys[pq[1]];
	}

	//Returns the key associated with index i.
	public Key keyOf(int i) {
		return keys[i];
	}

	//Change the key associated with index i to the specified value.
	public void changeKey(int i, int key) {
		keys[i] = key;
		swim[qp[i]];
		sink[qp[i]];
	}

	//Remove the key associated with index i.
	public void delete(int i) {
		int index = qp[i];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}

	//helper function
	private void swim(int k) {
		while(k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}

	private void sink(ink k) {
		while(2 * k <= N) {
			int j = 2 * k;
			if(j < N && greater(j, j + 1)) j++;
			if(!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	private void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}
}

/**Multiway merge priority-queue client
* ￼% more m1.txt A B C F G I I Z 
   % more m2.txt B D H P Q Q
   % more m3.txt
* ￼% java Multiway m1.txt m2.txt m3.txt
	 A A B B B C D E F F G H I I J N P Q Q Z
*/
public class Multiway {
	public static void merge(In[] streams) {
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);

		for(int i = 0; i < N; i++) {
			pq.insert(i, streams[i].readString());
		}

		while(!pq.isEmpty()) {
			System.out.println(pq.min());
			int i = pq.delMin();
			if(!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}
	}

	public static void main(String[] args) {
		int N = args.length;
		In[] streas = new In[N];
		for(int i = 0; i < N; i++) 
			streams[i] = new In(args[i]);
		merge(streams);
	}
}















