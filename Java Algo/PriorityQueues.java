/** Prority Queue & Heap Sort
* Proposition Q. In an N-key priority queue, the heap al- gorithms require no more than 1 + lg N compares for in- sert and no more than 2lg N compares for remove the maximum.
* Multiway heaps. It is not difficult to modify our code to build heaps based on an array representation of complete heap-ordered ternary trees, with an entry at position k larger than or equal to entries at positions 3k􏰅1, 3k, and 3k􏰄1 and smaller than or equal to entries at position ⎣(k+1) 􏰌 3⎦, for all indices between 1 and N in an array of N items, and not much more difficult to use d-ary heaps for any given d. There is a tradeoff between the lower cost from the reduced tree height (logd N) and the higher cost of finding the largest of the d children at each node. 
* guarantee nlogn and inplace but ineffient in cache
*/

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;

	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		return max;
	}

	private boolean less(int i, int j)
	{  return pq[i].compareTo(pq[j]) < 0;  }

	private void exch(int i, int j)
	{  Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;  }

	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}

	private void sink(int k) {
		while(2 * k <= N) {
			int j = 2 * k;
			if(J < N && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		//Construct heap order
		for(int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		//Move max to the end of Heap and keep the heap invariant by sink
		while(N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	//Comparator for sorting with different keys
	
}

